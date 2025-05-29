package com.workintech.fizzystore.service;


import com.workintech.fizzystore.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findById(Long id);
    User create(User user);
    User update(Long id, User user);
    void deleteById(Long id);
}
