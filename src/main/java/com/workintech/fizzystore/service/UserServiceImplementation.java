package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Role;
import com.workintech.fizzystore.entity.User;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("User with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        return user;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User userToUpdate = userRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("User with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (user.getName() != null) {
            userToUpdate.setName(user.getName());
        }
        if (user.getEmail() != null) {
            userToUpdate.setEmail(user.getEmail());
        }
        if (user.getPassword() != null) {
            userToUpdate.setPassword(user.getPassword());
        }
        if (user.getRole() != null) {
            userToUpdate.setRole(user.getRole());
        }
        if (user.getAddressList() != null) {
            userToUpdate.setAddressList(user.getAddressList());
        }
        if (user.getCreditCardList() != null) {
            userToUpdate.setCreditCardList(user.getCreditCardList());
        }

        return userRepository.save(userToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("User with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        userRepository.deleteById(id);
    }
}
