package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import com.projects.springbootdemo.LoginLogoutDemo.repository.DoctorRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
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
    @GetMapping("/view_appointments")
    public String viewAppointments(

            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) String date,
            Model model
    ){

        List<LocalDate> datePages = service.getAllAppointmentDates();

        LocalDate selectedDate;

        if(date == null){

            selectedDate = LocalDate.now();

        } else {

            selectedDate = LocalDate.parse(date);

        }

        int currentPage = datePages.indexOf(selectedDate);

        if(currentPage == -1){

            currentPage = 0;

        }

        if(page != null){

            currentPage = page;

            selectedDate = datePages.get(page);

        }

        Page<Appointment> appointments =
                service.getAppointmentsByDate(
                        selectedDate,
                        PageRequest.of(0, 50)
                );

        model.addAttribute("appointments", appointments);
        model.addAttribute("datePages", datePages);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("selectedDate", selectedDate);

        return "patient_ui_webview/view_appointments";
    }
    
}
