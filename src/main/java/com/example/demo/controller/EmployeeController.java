package com.example.demo.controller;


import com.example.demo.Service.EmployeeService;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity getEmpInAsc(){
        List<EmployeeList> list= employeeService.getEmpInAscByAge();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{age}")
    public ResponseEntity getEmpGreaterAge(@PathVariable String age){
        List<Employee> list = employeeService.getEmpGreaterAge(age);
        return new ResponseEntity(list, HttpStatus.OK);
    }


}
