package com.sahay.aayush.HMS_Demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@ToString
@Getter
@Setter
@Table(
        //rename the table
        name="patient_tbl",
        //specify the unique email rule.
        uniqueConstraints = {
        @UniqueConstraint(name = "unique_patient_email",columnNames = {"email"}),
        @UniqueConstraint(name = "unique_patient_name_birthdate",columnNames = {"name","birthDate"})
        },
        //to apply the indexes to the table [faster search over birthdate basis]
        indexes = {
        @Index(name = "idx_patient_birth_date",columnList = "birthDate")

        }

)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    //making the index based on the birthdate to make the query processing very fast.
    //faster retrival but the insertion will now become slow.

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
