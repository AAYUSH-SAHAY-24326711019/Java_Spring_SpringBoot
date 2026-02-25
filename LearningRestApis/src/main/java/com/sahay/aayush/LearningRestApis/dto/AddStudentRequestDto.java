package com.sahay.aayush.LearningRestApis.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddStudentRequestDto {
    //validation of the name
    @NotBlank(message = "message:Name is required")
    @Size(min=3,max=30,message="message:Name length must be 3 (min.) to 30 (max.) letters")
    private String name;

    //validation code of email
    @Email
    @NotBlank(message="message:Email is required") //required

    private String email;
}
