package com.sahay.aayush.LearningRestApis.controller;

import com.sahay.aayush.LearningRestApis.dto.AddStudentRequestDto;
import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import com.sahay.aayush.LearningRestApis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class StudentController{


    private final StudentService studentService;


    @GetMapping("/students")
    public ResponseEntity<List<StudentDto> >getStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }
    //by the help of the dto service , without directly communicating with the entity
    //or repository, we are able to fetch the data.



    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }


//    --------------------Post Mapping start--------------------
    //This is used to store / create
    //you can define body, status codes
    @PostMapping("/students")
    public ResponseEntity<StudentDto>
    createNewStudent(@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(
                HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

//    --------------------Post Mapping end--------------------

    //----Delete Mapping start -----
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    //----Delete Mapping end -----

    //---------Put Mapping start ---------------
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentDto> updateStudent
    (@PathVariable Long id,@RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id,addStudentRequestDto));
    }
    //---------Put Mapping end ---------------

    //---------Put Mapping start ---------------
    @PatchMapping("/students/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent
    (@PathVariable Long id,@RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
    //---------Put Mapping end ---------------

}
