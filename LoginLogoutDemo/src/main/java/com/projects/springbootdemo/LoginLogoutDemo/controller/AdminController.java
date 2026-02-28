package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.dto.AdminLoginRequestDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    @GetMapping("/")
    public String loginPage() {
        return "forward:/AdminLogin.html";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute AdminLoginRequestDto request,
                        BindingResult result) {

        if (result.hasErrors()) {
            return "redirect:/AdminLogin.html";
        }

        // later: call service for authentication

        return "redirect:/AdminDashboard.html";
    }
}

