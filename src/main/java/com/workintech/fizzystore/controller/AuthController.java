package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.RegisterRequest;
import com.workintech.fizzystore.dto.RegisterResponse;
import com.workintech.fizzystore.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/register")
    public RegisterResponse register(@Validated @RequestBody RegisterRequest request) {
        authService.register(request.getName(),request.getEmail(), request.getPassword());

        return new RegisterResponse("User account created successfully.");
    }
}
