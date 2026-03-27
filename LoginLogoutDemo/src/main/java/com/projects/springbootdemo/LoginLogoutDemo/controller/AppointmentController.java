package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.repository.DoctorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppointmentController {
    private final DoctorRepository doctorRepository;

    public AppointmentController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/appointments")
    public String showAppointmentPage(Model model) {
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
//        return "appointments_patients";
        return "patient_ui_webview/appointments_patients.html";
    }
}
