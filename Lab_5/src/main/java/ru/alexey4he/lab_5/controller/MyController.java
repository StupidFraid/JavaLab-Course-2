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
    private final AnnualBonusService annualBonusService;
    private final QuarterlyBonusService quarterlyBonusService;

    @Autowired
    public MyController(ValidationService validationService,
                        CheckUidService checkUidService,
                        AnnualBonusServiceImpl annualBonusService,
                        QuarterlyBonusServiceImpl quarterlyBonusService){
        this.validationService = validationService;
        this.checkUidService = checkUidService;
        this.annualBonusService = annualBonusService;
        this.quarterlyBonusService = quarterlyBonusService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        boolean isManagerMark;

        log.info("Send api request: {}", request);
        if (request.getPosition().isManager()){
             if (request.getWorkDays() > 93) {
                 ErrorCodes.valueOf("Необходимо ввести количество дней за квартал");
             }
             else {
                 annualBonusService.calculate(
                         request.getPosition(),
                         request.getSalary(),
                         request.getBonus(),
                         request.getWorkDays());
             }
        }
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .annualBonus(
                        annualBonusService.calculate(
                                request.getPosition(),
                                request.getSalary(),
                                request.getBonus(),
                                request.getWorkDays()))
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
