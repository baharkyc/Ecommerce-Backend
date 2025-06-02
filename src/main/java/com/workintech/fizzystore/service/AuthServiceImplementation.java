package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Role;
import com.workintech.fizzystore.entity.User;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.RoleRepository;
import com.workintech.fizzystore.repository.UserRepository;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AuthServiceImplementation implements AuthService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public User register(String name, String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent())
            throw new FizzyStoreException("Email already registered.", HttpStatus.CONFLICT);

        String encodedPassword = passwordEncoder.encode(password);

        Optional<Role> userRole = roleRepository.findAuthority("USER");

        if(userRole.isEmpty()) {
            Role role = new Role();
            role.setName("user");
            role.setCode("USER");

            userRole = Optional.of(roleRepository.save(role));
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        user.setRoles(Set.of(userRole.get()));

        return userRepository.save(user);
    }
}
