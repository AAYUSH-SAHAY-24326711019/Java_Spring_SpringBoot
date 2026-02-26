package com.sahay.aayush.HMS_Demo.repository;


import com.sahay.aayush.HMS_Demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
