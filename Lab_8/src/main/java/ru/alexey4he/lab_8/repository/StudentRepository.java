package ru.alexey4he.lab_8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.alexey4he.lab_8.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
