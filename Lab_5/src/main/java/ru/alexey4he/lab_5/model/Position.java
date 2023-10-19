package ru.alexey4he.lab_5.model;

import lombok.Getter;


@Getter
public enum Position {
    DEV(2.2, false),
    TESTER(1.4, false),
    SRE(2.4, false),
    PM(3.1, true),
    HR(1.2, false),
    TL(2.6, true);

    private final double positionCoefficient;
    private final boolean isManager;

    Position(double positionCoefficient, boolean isManager){
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
