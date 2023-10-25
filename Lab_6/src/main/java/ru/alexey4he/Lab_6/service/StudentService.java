package ru.alexey4he.Lab_6.service;

import org.springframework.stereotype.Service;
import ru.alexey4he.Lab_6.entity.Student;
import ru.alexey4he.Lab_6.model.StudentResponse;

import java.util.List;

@Service
public interface StudentService {
    List<Student> getAllStudents();

    Student getStudent(Long id);

    Student saveStudent(Student student);

    int deleteStudent(Long id);

}
