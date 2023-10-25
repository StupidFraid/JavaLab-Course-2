package ru.alexey4he.Lab_6.entity;


import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "age")
    private int age;

    public Student(){

    }

    public Student(String name, String surname, String faculty, int age){
        this.name = name;
        this.surname = surname;
        this.faculty = faculty;
        this.age = age;
    }

    public Student(Long id, String name, String surname, String faculty, int age){
        this.id = id;
        this.name = "NotFound";
        this.surname = "NotFound";
        this.faculty = "NotFound";
        this.age = 0;
    }


}
