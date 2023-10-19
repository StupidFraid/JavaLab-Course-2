package ru.alexey4he.lab_5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.model.Position;

import java.time.Year;
import java.util.Calendar;
@Slf4j
@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService {

    final int averageWorkDayInQuartal = 66;
    @Override
    public double calculate(Position position, double salary, double bonus, int workDays) {
        int month = Calendar.getInstance().get(Calendar.MONTH);


        log.info("Сейчас идет {} квартал", ((month + 1) / 3) + 1);
        log.info("Количество рабочих дней в последнем квартале: {}", checkWorkDay(workDays));
        return salary * bonus * checkWorkDay(workDays) * position.getPositionCoefficient() / checkWorkDay(workDays);
    }


    public int checkWorkDay(int workDay){
        if (workDay > averageWorkDayInQuartal){
            workDay = workDay - averageWorkDayInQuartal;
            return checkWorkDay(workDay);
        }
        return workDay;
    }
}
