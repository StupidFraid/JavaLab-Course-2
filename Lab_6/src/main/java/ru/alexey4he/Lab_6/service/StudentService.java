package ru.alexey4he.Lab_6.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.Lab_6.entity.Student;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(int id);

    Student saveStudent(Student student);

    void deleteStudent(int id);

}
