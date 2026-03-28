package com.projects.springbootdemo.LoginLogoutDemo.repository;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
