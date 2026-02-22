package com.sahay.aayush.LearningRestApis.impl;

import com.sahay.aayush.LearningRestApis.dto.StudentDto;
import com.sahay.aayush.LearningRestApis.entity.Student;
import com.sahay.aayush.LearningRestApis.repository.StudentRepository;
import com.sahay.aayush.LearningRestApis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //make the constructor for you ...jpa
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getAllStudents(){
        List<Student> students = studentRepository.findAll();
//        return students.stream().map(
//                student ->new StudentDto(student.getId(),
//                        student.getName(),
//                        student.getEmail())).toList();
        return students.stream().map(
                student ->modelMapper.map(student,StudentDto.class)).toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id"));
       return modelMapper.map(student,StudentDto.class);
    }
}
