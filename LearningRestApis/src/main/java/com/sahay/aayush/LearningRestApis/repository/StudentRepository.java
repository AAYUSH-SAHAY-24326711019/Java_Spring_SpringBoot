package com.sahay.aayush.LearningRestApis.repository;

import com.sahay.aayush.LearningRestApis.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
