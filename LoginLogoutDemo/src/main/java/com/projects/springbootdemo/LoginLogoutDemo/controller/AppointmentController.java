package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.repository.DoctorRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AppointmentController {
    private final DoctorRepository doctorRepository;
    private final AppointmentService service;



    @GetMapping("/appointments")
    public String showAppointmentPage(Model model) {
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
//        return "appointments_patients";
        return "patient_ui_webview/appointments_patients.html";
    }


    @PostMapping("/bookappointment")
    public String bookAppointment(@ModelAttribute Appointment appointment) {

        service.save(appointment);

        return "redirect:/appointments";
    }
}
