package com.workintech.fizzystore.service;


import com.workintech.fizzystore.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role findById(Long id);
    Role create(Role role);
    Role update(Long id, Role role);
    void deleteById(Long id);
}
