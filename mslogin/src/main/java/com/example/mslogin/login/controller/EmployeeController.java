package com.example.mslogin.login.controller;

import com.example.mslogin.login.Services.EmployeeService;
import com.example.mslogin.login.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/register")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee); // This will now handle the role assignment correctly
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
