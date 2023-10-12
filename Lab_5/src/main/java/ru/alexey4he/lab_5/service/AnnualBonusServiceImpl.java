package ru.alexey4he.lab_5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.model.Position;

import java.time.Year;
import java.util.Calendar;

@Slf4j
@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate(Position position, double salary, double bonus, int workDays){
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int days = Year.of(year).length();
        log.info("Количество дней в этом году: {}", days);
        return salary * bonus * year * position.getPositionCoefficient() / workDays;
    }
}
