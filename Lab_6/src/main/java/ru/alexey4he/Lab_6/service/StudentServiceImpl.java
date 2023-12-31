package ru.alexey4he.Lab_6.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexey4he.Lab_6.dao.StudentDAO;
import ru.alexey4he.Lab_6.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional
    public List<Student> getAllStudents(){
        return studentDAO.getAllStudent();
    }

    @Override
    @Transactional
    public Student getStudent(Long id) {
        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student){
        return studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public int deleteStudent(Long id) {
        return studentDAO.deleteStudent(id);
    }

}
