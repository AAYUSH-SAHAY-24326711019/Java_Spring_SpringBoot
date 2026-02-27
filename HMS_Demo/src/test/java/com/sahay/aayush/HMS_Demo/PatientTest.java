package com.sahay.aayush.HMS_Demo;

import com.sahay.aayush.HMS_Demo.entity.Patient;
import com.sahay.aayush.HMS_Demo.repository.PatientRepository;
import com.sahay.aayush.HMS_Demo.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test // if we give test , it will run the select query 2 times.
    public void testTransactionMethods(){
        Patient patient = patientService.getPatientById(1L);
        System.out.println(patient);
    }
}
