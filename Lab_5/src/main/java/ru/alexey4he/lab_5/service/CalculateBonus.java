package ru.alexey4he.lab_5.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.alexey4he.lab_5.model.Request;

@Service
@Slf4j
public class CalculateBonus {

    private static QuarterlyBonusService quarterlyBonusService;
    private static AnnualBonusService annualBonusService;

    @Autowired
    public CalculateBonus(QuarterlyBonusServiceImpl quarterlyBonusService, AnnualBonusServiceImpl annualBonusService) {
        this.quarterlyBonusService = quarterlyBonusService;
        this.annualBonusService = annualBonusService;
    }
    public static double cashBonus(Request request){
        double cashBonus;

        log.info("Messages from request: {}", request);

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
            log.info("CashBonus = {}", cashBonus);
        }

        return cashBonus;
    }
}
