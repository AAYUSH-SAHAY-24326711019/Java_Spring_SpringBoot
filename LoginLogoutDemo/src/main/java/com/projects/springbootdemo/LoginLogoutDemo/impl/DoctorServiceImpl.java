package com.projects.springbootdemo.LoginLogoutDemo.impl;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.repository.DoctorRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository repository;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return repository.save(doctor);
    }
}
