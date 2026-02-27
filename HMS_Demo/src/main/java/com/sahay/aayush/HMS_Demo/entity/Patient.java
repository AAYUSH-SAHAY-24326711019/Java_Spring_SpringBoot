package com.sahay.aayush.HMS_Demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    @Column(name="patient_name",nullable = false, length=40) //to rename the table and make it not null
    private String name; //and giving it the length of 40
    //making the index based on the birthdate to make the query processing very fast.
    //faster retrival but the insertion will now become slow.

    private LocalDate birthDate;
    // if dont need gender then @ToString.Exclude

    //adding a new field and making this a unique field.
    @Column(unique = true,nullable = false) //this also makes the field required.
    private String email;

    private String gender;

    //making a new field to store the timestamp of the record creation
    @CreationTimestamp
    @Column(updatable = false) //cannot update.
    private LocalDateTime createdAt;
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
