package ru.alexey4he.Lab_6.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexey4he.Lab_6.entity.Student;
import ru.alexey4he.Lab_6.model.StatusCode;
import ru.alexey4he.Lab_6.model.StudentResponse;
import ru.alexey4he.Lab_6.service.StudentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        return allStudents;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public StudentResponse saveStudent(@RequestBody Student student) {
        StudentResponse response = new StudentResponse(
                studentService.saveStudent(student), StatusCode.ADD);
        return response;
    }

    @PutMapping("/students")
    public StudentResponse updateStudent(@RequestBody Student student){
        StudentResponse response = new StudentResponse(
                studentService.saveStudent(student), StatusCode.UPDATE);
        return response;
    }

    @DeleteMapping("/students/{id}")
    public StudentResponse updateStudent(@PathVariable("id") Long id) {
//        return studentService.deleteStudent(id);
        Student deleteStudentInfo = studentService.getStudent(id);
        int stateDeleteStudent = studentService.deleteStudent(id);
        log.info(String.valueOf(stateDeleteStudent));
        if (stateDeleteStudent > 0){
            return new StudentResponse(deleteStudentInfo, StatusCode.DELETE);
        }
        else {
            return new StudentResponse(deleteStudentInfo, StatusCode.ERRORDELETE);
        }
    }


}
