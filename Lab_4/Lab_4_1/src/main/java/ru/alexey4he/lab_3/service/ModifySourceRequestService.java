package ru.alexey4he.lab_3.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_3.model.Request;

@Service
@Qualifier("ModifySourceRequestService")
public class ModifySourceRequestService implements ModifyRequestService{
    @Override
    public Request modify(Request request){
        request.setSource("User send messages");

        return request;
    }
}
