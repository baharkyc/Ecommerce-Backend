package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.config.JwtUtil;
import com.workintech.fizzystore.dto.*;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    public AuthController (AuthService authService, JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/register")
    public RegisterResponse register(@Validated @RequestBody RegisterRequestDto request) {

        authService.register(request.getName(),request.getEmail(), request.getPassword());

        return new RegisterResponse("User account created successfully.");
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Validated @RequestBody LoginRequestDto request) {

        return authService.login(request.getEmail(), request.getPassword());

    }

    @GetMapping("/verify")
    public VerifyResponseDto verifyToken(@RequestHeader("Authorization") String authHeader) {

        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            return authService.verifyToken(authHeader);

        } else {
            throw new FizzyStoreException("Authorization header must start with Bearer", HttpStatus.UNAUTHORIZED);
        }
    }

}
