package com.sahay.aayush.LearningRestApis.service;

import com.sahay.aayush.LearningRestApis.dto.AddStudentRequestDto;
import com.sahay.aayush.LearningRestApis.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
}
