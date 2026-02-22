package com.sahay.aayush.LearningRestApis.controller;

import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import com.sahay.aayush.LearningRestApis.entity.Student;
import com.sahay.aayush.LearningRestApis.repository.StudentRepository;
import com.sahay.aayush.LearningRestApis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController{

    /*@GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(1234,"student_name","student_email@gmail.com");
    }  commented*/

    // private final StudentRepository studentRepository;
       //commented after making the StudentServiceImpl
    //connect the controller to the service

    private final StudentService studentService;

    /*public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    } commented since not required */

    @GetMapping("/students")
    public List<StudentDto> getStudent(){
        return studentService.getAllStudents();
    } //by the help of the dto service , without directly communicating with the entity
    //or repository, we are able to fetch the data.


    //added other url pattern
    @GetMapping("/students/{id}")
//    public StudentDto getStudentById(@PathVariable Long id){
    public StudentDto getStudentById(@PathVariable Long id){
//        return new StudentDto(1234,"student_name_on id request","student_email@gmail.com");
//    return "Path variable "+id+" and name is :"+name;
        return studentService.getStudentById(id);
    }


}
