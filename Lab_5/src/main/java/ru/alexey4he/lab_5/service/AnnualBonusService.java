package ru.alexey4he.lab_5.service;

import ru.alexey4he.lab_5.model.Position;

public interface AnnualBonusService {
    double calculate(Position position, double salary, double bonus, int workDays);
}
