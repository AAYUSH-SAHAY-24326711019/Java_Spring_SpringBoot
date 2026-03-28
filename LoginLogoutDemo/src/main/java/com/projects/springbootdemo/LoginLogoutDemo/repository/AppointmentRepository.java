package com.projects.springbootdemo.LoginLogoutDemo.repository;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT DISTINCT a.adate FROM Appointment a ORDER BY a.adate")
    List<LocalDate> findDistinctAppointmentDates();
    Page<Appointment> findByAdate(LocalDate adate, Pageable pageable);
}
