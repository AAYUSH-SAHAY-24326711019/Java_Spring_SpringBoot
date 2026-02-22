package com.sahay.aayush.LearningRestApis.controller;

import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1234,"student_name","student_email@gmail.com");
    }
    //added other url pattern
    @GetMapping("/student/{id}")
    public StudentDto getStudentById(){
        return new StudentDto(1234,"student_name_on id request","student_email@gmail.com");
    }

}
