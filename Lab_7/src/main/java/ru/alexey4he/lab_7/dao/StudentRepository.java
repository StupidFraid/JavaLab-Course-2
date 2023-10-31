package ru.alexey4he.lab_7.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.alexey4he.lab_7.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
