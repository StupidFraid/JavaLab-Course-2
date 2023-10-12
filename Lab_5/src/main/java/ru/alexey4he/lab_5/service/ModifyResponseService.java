package ru.alexey4he.lab_5.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.model.Response;
@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
