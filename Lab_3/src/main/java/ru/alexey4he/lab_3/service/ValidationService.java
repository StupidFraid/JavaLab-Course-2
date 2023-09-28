package ru.alexey4he.lab_3.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.alexey4he.lab_3.exception.ValidationFailedException;
@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
