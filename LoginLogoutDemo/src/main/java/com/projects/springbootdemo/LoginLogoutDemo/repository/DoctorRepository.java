package com.projects.springbootdemo.LoginLogoutDemo.repository;

import com.projects.springbootdemo.LoginLogoutDemo.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository  extends JpaRepository<Doctor, Long> {
}
