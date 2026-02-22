package com.sahay.aayush.LearningRestApis.impl;

import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import com.sahay.aayush.LearningRestApis.entity.Student;
import com.sahay.aayush.LearningRestApis.repository.StudentRepository;
import com.sahay.aayush.LearningRestApis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //make the constructor for you ...jpa
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return students.stream().map(
                student ->new StudentDto(student.getId(),
                        student.getName(),
                        student.getEmail())).toList();

    }
}
