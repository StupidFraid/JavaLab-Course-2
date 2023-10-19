package ru.alexey4he.lab_5.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alexey4he.lab_5.exception.UnsupportedCodeException;
import ru.alexey4he.lab_5.exception.ValidationFailedException;
import ru.alexey4he.lab_5.model.*;
import ru.alexey4he.lab_5.service.*;
import ru.alexey4he.lab_5.util.DateTimeUtil;

import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationService validationService;
    private final CheckUidService checkUidService;

    @Autowired
    public MyController(ValidationService validationService,
                        CheckUidService checkUidService){
        this.validationService = validationService;
        this.checkUidService = checkUidService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult) {
        log.info("Send api request: {}", request);


        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .bonus(CalculateBonus.cashBonus(request))
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
