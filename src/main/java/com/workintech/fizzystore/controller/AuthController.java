package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.LoginRequestDto;
import com.workintech.fizzystore.dto.LoginResponseDto;
import com.workintech.fizzystore.dto.RegisterRequestDto;
import com.workintech.fizzystore.dto.RegisterResponse;
import com.workintech.fizzystore.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public RegisterResponse register(@Validated @RequestBody RegisterRequestDto request) {

        authService.register(request.getName(),request.getEmail(), request.getPassword());

        return new RegisterResponse("User account created successfully.");
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Validated @RequestBody LoginRequestDto request) {

        authService.login(request.getEmail(), request.getPassword());

        return new LoginResponseDto("Login successful.");
    }


}
