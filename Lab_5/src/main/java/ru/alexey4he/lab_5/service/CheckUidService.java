package ru.alexey4he.lab_5.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.exception.UnsupportedCodeException;
import ru.alexey4he.lab_5.model.Request;
@Service
public interface CheckUidService {
    void checkUid(Request request) throws UnsupportedCodeException;
}
