package ru.alexey4he.lab_3.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_3.model.Response;

import java.util.UUID;
@Service
@Qualifier("ModifyOperationUidResponseService")
public class ModifyOperationUidResponseService implements ModifyResponseService{
    @Override
    public Response modify(Response response){
        UUID uuid = UUID.randomUUID();

        response.setOperationUid(uuid.toString());

        return response;
    }
}
