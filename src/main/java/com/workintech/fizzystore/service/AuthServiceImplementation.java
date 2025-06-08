package com.workintech.fizzystore.service;

import com.workintech.fizzystore.config.JwtUtil;
import com.workintech.fizzystore.dto.LoginResponseDto;
import com.workintech.fizzystore.dto.RegisterResponse;
import com.workintech.fizzystore.dto.VerifyResponseDto;
import com.workintech.fizzystore.entity.Role;
import com.workintech.fizzystore.entity.User;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.RoleRepository;
import com.workintech.fizzystore.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImplementation implements AuthService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImplementation(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this. passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }


    @Override
    public User register(String name, String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent())
            throw new FizzyStoreException("Email already registered.", HttpStatus.CONFLICT);

        String encodedPassword = passwordEncoder.encode(password);

        Optional<Role> userRole = roleRepository.findAuthority("CUSTOMER");

        if(userRole.isEmpty()) {
            Role role = new Role();
            role.setName("Customer");
            role.setCode("CUSTOMER");

            userRole = Optional.of(roleRepository.save(role));
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(Set.of(userRole.get()));

        return userRepository.save(user);
    }

    @Override
    public LoginResponseDto login(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {
            User user = optionalUser.get();

            if (passwordEncoder.matches(password, user.getPassword())) {
                //token generation
                String token = jwtUtil.generateToken(user.getEmail());

                return new LoginResponseDto("Login successful",user.getName(), token);
            } else {
                throw new FizzyStoreException("Invalid password.", HttpStatus.UNAUTHORIZED);
            }
        } else {
            throw new FizzyStoreException("User not found with email: " + email, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public VerifyResponseDto verifyToken(String token) {

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        if (jwtUtil.validateToken(token)) {
            String email = jwtUtil.extractEmail(token);
            return new VerifyResponseDto(email, token, "Token is valid.");

        } else {

            return new VerifyResponseDto(null, null, "Token is invalid.");
        }
    }


}
