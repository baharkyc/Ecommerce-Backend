package com.workintech.fizzystore.controller;

import com.workintech.fizzystore.dto.RoleResponseDto;
import com.workintech.fizzystore.entity.Role;
import com.workintech.fizzystore.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public List<RoleResponseDto> getRoles() {
        return roleService
                .getAll()
                .stream()
                .map(role -> new RoleResponseDto(
                        role.getId(),
                        role.getName(),
                        role.getCode()
                ))
                .toList();
    }
}
