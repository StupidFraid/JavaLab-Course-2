package ru.alexey4he.lab_5.service;

import org.junit.jupiter.api.Test;
import ru.alexey4he.lab_5.model.Position;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class QuarterlyBonusServiceImplTest {

    @Test
    void calculate() {
        // given
        Position position = Position.TL;
        double bonus = 2.6;
        int workDays = 50;
        double salary = 100000;

//        when
        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus, workDays);

//        then
        double expected = 676000;
        assertThat(result).isEqualTo(expected);

    }
}