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

        workDays = checkWorkDay(workDays);

        log.info("Количество рабочих дней последнем квартале: {}", workDays);
        return salary * bonus * workDays * position.getPositionCoefficient() / workDays;
    }


    public int checkWorkDay(int workDay){
        if (workDay > averageWorkDayInQuartal){
            workDay = workDay - averageWorkDayInQuartal;
            checkWorkDay(workDay);
        }

        return workDay;
    }
}
