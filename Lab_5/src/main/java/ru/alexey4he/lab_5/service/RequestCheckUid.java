package ru.alexey4he.lab_5.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.exception.UnsupportedCodeException;
import ru.alexey4he.lab_5.model.Request;

@Service
public class RequestCheckUid implements CheckUidService{
    @Override
    public void checkUid(Request request) throws UnsupportedCodeException {
        if(request.getUid().equals("123")){
            throw new UnsupportedCodeException("UID равен 123");
        }
    }
}
