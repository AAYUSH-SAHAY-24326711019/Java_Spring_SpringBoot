package com.projects.springbootdemo.LoginLogoutDemo.controller;

import com.projects.springbootdemo.LoginLogoutDemo.dto.AdminLoginRequestDto;
import com.projects.springbootdemo.LoginLogoutDemo.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/* Updated the logic for Admin Controller, [Delete section on print]
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
 */
@Controller
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

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

        boolean isValid = adminService.authenticate(
                request.getEmail(),
                request.getPassword()
        );

        if (!isValid) {
            return "redirect:/AdminLogin.html";
        }

        return "redirect:/AdminDashboard.html";
    }

}

