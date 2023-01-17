package com.example.demo.Service;


import com.example.demo.pojo.Employee;
import com.example.demo.pojo.EmployeeList;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    List<EmployeeList> getEmpInAscByAge();

    List<Employee> getEmpGreaterAge(String age);

}
