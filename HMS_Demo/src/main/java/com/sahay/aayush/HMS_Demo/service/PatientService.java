package com.sahay.aayush.HMS_Demo.service;


import com.sahay.aayush.HMS_Demo.entity.Patient;
import com.sahay.aayush.HMS_Demo.repository.PatientRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PatientService {
    private final PatientRepository patientRepository;

    //adding this line after the p1.setname() as below:
    private final EntityManager entityManager;

    @Transactional
    //Since Transactional , Select query was fired just 1 time, early called 2 times.
    public Patient getPatientById(Long id){
        Patient p1 = patientRepository.findById(id).orElseThrow();

        Patient p2 = patientRepository.findById(id).orElseThrow();
            // a transaction can also do the update operation.

        System.out.println(p1==p2);

        p1.setName("Yoyo");

        //patientRepository.save(p1); // There is no need to do it , the line above will
        //save it automatically for the purpose of the persistence.

        return p1;

    }
}
