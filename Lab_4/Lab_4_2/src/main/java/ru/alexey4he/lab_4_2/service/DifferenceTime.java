package ru.alexey4he.lab_4_2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_4_2.model.ErrorMessages;
import ru.alexey4he.lab_4_2.model.Request;
import ru.alexey4he.lab_4_2.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class DifferenceTime {
    public static String checkDifferenceTime(Request request, Response response){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");
        String stringDateRequest = request.getSystemTime();
        String stringDateResponse = response.getSystemTime();
        try {
            Date dateRequest = dateFormat.parse(stringDateRequest);
            Date dateResponse = dateFormat.parse(stringDateResponse);

            long differenceInMilliseconds = dateResponse.getTime() - dateRequest.getTime();
//            long differenceInSeconds = differenceInMilliseconds / 1000;
            log.info("{} Milliseconds", differenceInMilliseconds);
            return null;

        } catch (Exception e){
            log.error("Произошла ошибка во время расчета потраченного времени");
            return "";
        }
    }
}
