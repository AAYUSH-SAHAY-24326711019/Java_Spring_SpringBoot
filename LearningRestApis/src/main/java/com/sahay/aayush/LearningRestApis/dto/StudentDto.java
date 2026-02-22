package com.sahay.aayush.LearningRestApis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private long id;
    private String name;
    private String email;
}
//@Data annotation comes from lombok, it will make the getters and setters on the fly.
//@AllArgsConstructor will make the constructor of all the arguments. -from lombok
 /*
 //-------------------------------------------------------------------------------
    //but you can also use the annotation i.e. data annotation.
    // it's an old way to work
    //made the do nothing constructor
    public StudentDto() {
    }

    //made the most concrete constructor.
    public StudentDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //making the getters and setters


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
 //-------------------------------------------------------------------------------
*/