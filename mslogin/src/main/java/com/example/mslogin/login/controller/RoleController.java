package com.example.mslogin.login.controller;

import com.example.mslogin.login.entity.Role;
import com.example.mslogin.login.repository.RoleRepository;
import com.example.mslogin.models.RoleModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @GetMapping
    public List<RoleModel> getAllRoles() {
        List<RoleModel> roleModels = new ArrayList<>();
        roleRepository.findAll().forEach(r->{
            roleModels.add(modelMapper.map(r, RoleModel.class));
        });
        return roleModels;
    }
}
