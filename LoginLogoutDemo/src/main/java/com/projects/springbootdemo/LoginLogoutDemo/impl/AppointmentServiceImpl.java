package com.projects.springbootdemo.LoginLogoutDemo.impl;


import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.repository.AppointmentRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;

    @Override
    public Appointment save(Appointment appointment) {

        return repository.save(appointment);

    }
}
