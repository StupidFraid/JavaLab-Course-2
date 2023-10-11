package ru.alexey4he.lab_4_2.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_4_2.model.Response;
@Service
public interface ModifyResponseService {
    Response modify(Response response);
}
