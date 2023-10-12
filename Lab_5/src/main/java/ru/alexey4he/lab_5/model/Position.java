package ru.alexey4he.lab_5.model;

import lombok.Getter;


@Getter
public enum Position {
    DEV(2.2, false),
    HR(1.2, false),
    TL(2.6, true);

    private final double positionCoefficient;
    private final boolean isManager;

    Position(double positionCoefficient, boolean isManager){
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
