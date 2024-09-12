package com.example.mslogin.login.controller;

import com.example.mslogin.login.Services.EmployeeService;
import com.example.mslogin.login.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee login(@RequestBody Employee loginRequest) {
        Employee employee = employeeService.getEmployeeByEmail(loginRequest.getEmail());
        if (employee != null && employee.getPassword().equals(loginRequest.getPassword())) {
            return employee; // or return a token if you're using JWT
        }
        throw new RuntimeException("Invalid email or password");
    }
}
