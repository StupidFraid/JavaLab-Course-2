package ru.alexey4he.Lab_6.model;

import ru.alexey4he.Lab_6.entity.Discipline;

public class DisciplineResponse {
    private Discipline discipline;
    private StatusCode statusCode;
    private TypeOperations typeOperations;

    public DisciplineResponse(TypeOperations typeOperations, Discipline discipline, StatusCode statusCode){
        this.typeOperations = typeOperations;
        this.discipline = discipline;
        this.statusCode = statusCode;
    }
}
