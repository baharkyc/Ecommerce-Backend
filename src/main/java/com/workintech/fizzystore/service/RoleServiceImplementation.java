package com.workintech.fizzystore.service;

import com.workintech.fizzystore.entity.Product;
import com.workintech.fizzystore.entity.Role;
import com.workintech.fizzystore.exceptions.FizzyStoreException;
import com.workintech.fizzystore.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImplementation implements RoleService{

    private RoleRepository roleRepository;

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Role with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        return role;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Role roleToUpdate = roleRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Role with id: " + id + " not found.", HttpStatus.NOT_FOUND));

        if (role.getName() != null) {
            roleToUpdate.setName(role.getName());
        }
        if (role.getCode() != null) {
            roleToUpdate.setCode(role.getCode());
        }
        if (role.getUsers() != null) {
            roleToUpdate.setUsers(role.getUsers());
        }

        return roleRepository.save(roleToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new FizzyStoreException("Role with id: " + id + " not found.", HttpStatus.NOT_FOUND)
        );
        roleRepository.deleteById(id);
    }
}
