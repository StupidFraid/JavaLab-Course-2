package ru.alexey4he.lab_4_2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.alexey4he.lab_4_2.exception.ValidationFailedException;

@Slf4j
@Service
public class RequestValidationService implements ValidationService{
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException{
        if (bindingResult.hasErrors()){
            log.error("bindingResult: {}", bindingResult.getFieldError().toString());
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
