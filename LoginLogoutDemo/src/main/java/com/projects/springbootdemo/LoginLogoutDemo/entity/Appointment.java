package com.projects.springbootdemo.LoginLogoutDemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "appointments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aname;

    private Long adoctor;   // doctorId from dropdown

    private LocalDate adate;

    private String townDistrict;

    private String areaLocality;

    private String state;
}
