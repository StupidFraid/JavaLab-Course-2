package ru.alexey4he.Lab_6.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.alexey4he.Lab_6.entity.Student;
import ru.alexey4he.Lab_6.model.StatusCode;
import ru.alexey4he.Lab_6.model.StudentResponse;
import ru.alexey4he.Lab_6.model.TypeOperations;
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
    public StudentResponse getStudent(@PathVariable("id") long id) {

        Student findStudent = studentService.getStudent(id);

        if (findStudent != null){
            return new StudentResponse(TypeOperations.FIND, findStudent, StatusCode.OK);
        }
        else {
            return new StudentResponse(TypeOperations.FIND,null, StatusCode.ERROR);
        }
    }

    @PostMapping("/students")
    public StudentResponse saveStudent(@RequestBody Student student) {
        StudentResponse response = new StudentResponse(
                TypeOperations.ADD, studentService.saveStudent(student), StatusCode.OK);
        return response;
    }

    @PutMapping("/students")
    public StudentResponse updateStudent(@RequestBody Student student){
        Student existingStudent = studentService.getStudent(student.getId());
        StudentResponse response;
        if (existingStudent != null){
            response = new StudentResponse(
                    TypeOperations.UPDATE, studentService.saveStudent(student), StatusCode.OK);
        }
        else {
            response = new StudentResponse(
                    TypeOperations.UPDATE, null, StatusCode.ERROR);

        }
        return response;
    }

    @DeleteMapping("/students/{id}")
    public StudentResponse updateStudent(@PathVariable("id") long id) {
        Student deleteStudentObject = studentService.getStudent(id);
        int stateDeleteStudent = studentService.deleteStudent(id);
        if (stateDeleteStudent > 0){
            return new StudentResponse(TypeOperations.DELETE, deleteStudentObject, StatusCode.OK);
        }
        else {
            return new StudentResponse(TypeOperations.DELETE, deleteStudentObject, StatusCode.ERROR);
        }
    }


}
