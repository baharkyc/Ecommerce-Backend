package com.workintech.fizzystore.service;

import com.workintech.fizzystore.dto.LoginResponseDto;
import com.workintech.fizzystore.dto.VerifyResponseDto;
import com.workintech.fizzystore.entity.User;

public interface AuthService {

    User register(String name, String email, String password);
    LoginResponseDto login(String email, String password);
    VerifyResponseDto verifyToken(String token);

}
