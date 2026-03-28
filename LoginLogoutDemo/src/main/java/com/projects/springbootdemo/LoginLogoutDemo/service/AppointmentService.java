package com.projects.springbootdemo.LoginLogoutDemo.service;


import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {

    public Appointment save(Appointment appointment);

}
