package ru.alexey4he.Lab_6.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Data
@Entity
@Table(name = "discipline")
public class Discipline {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private int weight;

    public Discipline(){

    }

    public Discipline( String name, String description, int weight){
        this.name = name;
        this.description = description;
        this.weight = weight;
    }
}
