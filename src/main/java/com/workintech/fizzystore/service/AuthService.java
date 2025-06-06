package com.workintech.fizzystore.service;

import com.workintech.fizzystore.dto.LoginResponseDto;
import com.workintech.fizzystore.dto.RegisterResponse;
import com.workintech.fizzystore.entity.User;

public interface AuthService {

    User register(String name, String email, String password);
    User login(String email, String password);

}
