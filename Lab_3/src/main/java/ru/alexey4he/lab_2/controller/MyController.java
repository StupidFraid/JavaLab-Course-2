package ru.alexey4he.lab_2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.alexey4he.lab_2.exception.UnsupportedCodeException;
import ru.alexey4he.lab_2.exception.ValidationFailedException;
import ru.alexey4he.lab_2.model.Request;
import ru.alexey4he.lab_2.model.Response;
import ru.alexey4he.lab_2.service.CheckUidService;
import ru.alexey4he.lab_2.service.ValidationService;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class MyController {

    private final ValidationService validationService;
    private final CheckUidService checkUidService;

    @Autowired
    public MyController(ValidationService validationService, CheckUidService checkUidService){
        this.validationService = validationService;
        this.checkUidService = checkUidService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@Valid @RequestBody Request request,
                                             BindingResult bindingResult){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();

    try {
        validationService.isValid(bindingResult);
        checkUidService.checkUid(request);
    } catch (ValidationFailedException e){
        response.setCode("failed");
        response.setErrorCode("ValidationException");
        response.setErrorMessage("Ошибка валидации");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    } catch (UnsupportedCodeException e){
        response.setCode("failed");
        response.setErrorCode("UnsuportedCodeException");
        response.setErrorMessage("UID = 123, UnsuportedCodeException");
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    } catch (Exception e) {
        response.setCode("failed");
        response.setErrorCode("UnknownException");
        response.setErrorMessage("Произошла непредвиденная ошибка");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
