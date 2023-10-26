package ru.alexey4he.Lab_6.model;

import lombok.Data;
import ru.alexey4he.Lab_6.entity.Discipline;

@Data
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
