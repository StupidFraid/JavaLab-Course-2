package ru.alexey4he.lab_3.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_3.exception.UnsupportedCodeException;
import ru.alexey4he.lab_3.model.Request;
@Service
public interface CheckUidService {
    void checkUid(Request request) throws UnsupportedCodeException;
}
