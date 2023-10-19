package ru.alexey4he.lab_5.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.model.Request;

@Service
public class calculateBonus {
    private AnnualBonusServiceImpl quarterlyBonusService;
    private AnnualBonusServiceImpl annualBonusService;

    public double cashBonus(Request request){
        double cashBonus;

        if (request.getPosition().isManager()) {
            cashBonus = quarterlyBonusService.calculate(
                    request.getPosition(),
                    request.getSalary(),
                    request.getBonus(),
                    request.getWorkDays());
        } else {
            cashBonus = annualBonusService.calculate(
                    request.getPosition(),
                    request.getSalary(),
                    request.getBonus(),
                    request.getWorkDays());
        }

        return cashBonus;
    }
}
