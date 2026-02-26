package com.sahay.aayush.HMS_Demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    private LocalDate birthDate;
    // if dont need gender then @ToString.Exclude
    private String gender;
/* Making a To String explicitly

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                '}';
    }


 */
}
