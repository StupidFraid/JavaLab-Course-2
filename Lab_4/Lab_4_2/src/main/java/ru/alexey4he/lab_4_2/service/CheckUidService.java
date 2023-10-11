package ru.alexey4he.lab_4_2.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_4_2.exception.UnsupportedCodeException;
import ru.alexey4he.lab_4_2.model.Request;
@Service
public interface CheckUidService {
    void checkUid(Request request) throws UnsupportedCodeException;
}
