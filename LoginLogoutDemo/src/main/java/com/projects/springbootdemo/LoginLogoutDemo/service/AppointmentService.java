package com.projects.springbootdemo.LoginLogoutDemo.service;


import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.repository.AppointmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface AppointmentService {

    public Appointment save(Appointment appointment);

    Page<Appointment> getAppointmentsByDate(
            LocalDate date,
            Pageable pageable
    );

    public List<LocalDate> getAllAppointmentDates();
}
