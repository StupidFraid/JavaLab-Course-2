package ru.alexey4he.Lab_6.model;

import lombok.Data;
import ru.alexey4he.Lab_6.entity.Student;

@Data
public class StudentResponse {
    private Student student;
    private StatusCode status;
    private TypeOperations typeOperations;



    public StudentResponse(TypeOperations typeOperations, Student student, StatusCode statusCode){
        this.typeOperations = typeOperations;
        this.student = student;
        this.status = statusCode;
    };
}
