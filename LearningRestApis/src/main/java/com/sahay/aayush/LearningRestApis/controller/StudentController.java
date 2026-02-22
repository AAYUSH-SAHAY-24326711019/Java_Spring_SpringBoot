package com.sahay.aayush.LearningRestApis.controller;

import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import com.sahay.aayush.LearningRestApis.entity.Student;
import com.sahay.aayush.LearningRestApis.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    /*@GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1234,"student_name","student_email@gmail.com");
    }  commented*/

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentRepository.findAll();
    }


    //added other url pattern
    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(1234,"student_name_on id request","student_email@gmail.com");
    }

}
