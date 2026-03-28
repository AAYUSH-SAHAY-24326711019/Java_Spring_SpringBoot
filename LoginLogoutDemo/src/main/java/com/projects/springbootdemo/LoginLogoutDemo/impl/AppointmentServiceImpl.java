package com.projects.springbootdemo.LoginLogoutDemo.impl;


import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import com.projects.springbootdemo.LoginLogoutDemo.repository.AppointmentRepository;
import com.projects.springbootdemo.LoginLogoutDemo.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;

    @Override
    public Appointment save(Appointment appointment) {

        return repository.save(appointment);

    }

    @Override
    public Page<Appointment> getAppointmentsByDate(
            LocalDate date,
            Pageable pageable
    ) {

        return repository.findByAdate(date, pageable);

    }

    @Override
    public List<LocalDate> getAllAppointmentDates() {

        return repository.findDistinctAppointmentDates();

    }
}
