package ru.alexey4he.Lab_6.dao;

import org.springframework.stereotype.Repository;
import ru.alexey4he.Lab_6.entity.Student;

import java.util.List;

@Repository
public interface StudentDAO {
    List<Student> getAllStudent();

    Student saveStudent(Student student);

    Student getStudent(long id);

    void deleteStudent(long id);
}
