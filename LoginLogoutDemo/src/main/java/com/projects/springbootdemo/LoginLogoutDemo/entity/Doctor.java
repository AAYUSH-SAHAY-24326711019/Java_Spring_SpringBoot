package com.projects.springbootdemo.LoginLogoutDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Entity
@Table(name = "doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Doctor {

    @Id
    private Integer doctorId;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    private Integer age;

    private LocalDateTime registeredDate;

    private LocalDate dateOfEffect;

    private LocalDate endOfContract;

    // Auto-generate ID & date
    @PrePersist
    public void beforeSave() {
        this.doctorId = new Random().nextInt(9000) + 1000; // 4 digit
        this.registeredDate = LocalDateTime.now();
    }

    // Getters & Setters
}
