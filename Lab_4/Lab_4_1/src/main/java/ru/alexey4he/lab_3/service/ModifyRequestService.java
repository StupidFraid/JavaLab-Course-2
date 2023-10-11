package ru.alexey4he.lab_3.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_3.model.Request;

@Service
public interface ModifyRequestService {
    Request modify(Request request);
}
