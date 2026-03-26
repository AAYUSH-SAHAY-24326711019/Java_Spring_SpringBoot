package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
