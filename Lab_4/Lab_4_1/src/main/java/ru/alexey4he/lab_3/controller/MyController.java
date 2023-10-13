package ru.alexey4he.lab_3.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alexey4he.lab_3.exception.UnsupportedCodeException;
import ru.alexey4he.lab_3.exception.ValidationFailedException;
import ru.alexey4he.lab_3.model.*;
import ru.alexey4he.lab_3.service.CheckUidService;
import ru.alexey4he.lab_3.service.ModifyRequestService;
import ru.alexey4he.lab_3.service.ModifyResponseService;
import ru.alexey4he.lab_3.service.ValidationService;
import ru.alexey4he.lab_3.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final CheckUidService checkUidService;
    private final ModifyRequestService modifyRequestService;
    private final ModifyResponseService modifyResponseService;
    private final ModifyRequestService modifySourceRequestService;

    @Autowired
    public MyController(ValidationService validationService, CheckUidService checkUidService,
                        @Qualifier("ModifySourceRequestService") ModifyRequestService modifySourceRequestService,
                        @Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService,
                        @Qualifier("ModifySystemNameRequestService") ModifyRequestService modifyRequestService){
        this.validationService = validationService;
        this.checkUidService = checkUidService;
        this.modifyResponseService = modifyResponseService;
        this.modifyRequestService = modifyRequestService;
        this.modifySourceRequestService = modifySourceRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));
        log.info("request: {}", request);
        modifySourceRequestService.modify(request);
        log.info("Modify request: {}", request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();

        log.info("response: {}", response);


        try {
        validationService.isValid(bindingResult);
        checkUidService.checkUid(request);
    } catch (ValidationFailedException e){
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
        response.setErrorMessage(ErrorMessages.VALIDATION);
        log.error("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (UnsupportedCodeException e){
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNSUPPORTED);
        log.error("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    } catch (Exception e) {
        response.setCode(Codes.FAILED);
        response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
        response.setErrorMessage(ErrorMessages.UNKNOWN);
        log.error("response: {}", response);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        request.setSystemTime(response.getSystemTime());
        modifyRequestService.modify(request);
        modifyResponseService.modify(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
