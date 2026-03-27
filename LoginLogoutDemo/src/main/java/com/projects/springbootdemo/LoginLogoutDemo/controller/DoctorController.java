package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.repository.DoctorRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

@RestController
@RequestMapping("/doctor")
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/register")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return service.saveDoctor(doctor);
    }
}
