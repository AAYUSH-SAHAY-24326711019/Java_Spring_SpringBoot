package com.sahay.aayush.LearningRestApis.impl;

import com.sahay.aayush.LearningRestApis.dto.AddStudentRequestDto;
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


//        return students.stream().map(
//                student ->modelMapper.map(student,StudentDto.class)).toList();

        return students.stream().map(
                student -> new StudentDto(
                        student.getId(),
                        student.getName(),
                        student.getEmail()
                )
        ).toList();

    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id"));
       return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        //adding using student repository
        Student newStudent = modelMapper.map(addStudentRequestDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id :"+id);
        }else{
            studentRepository.deleteById(id);
        }
    }
}
