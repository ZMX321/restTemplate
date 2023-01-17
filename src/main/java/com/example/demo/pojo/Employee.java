package com.example.demo.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer id;

    private String employee_name;

    private String employee_salary;

    private Integer employee_age;

    private String profile_image;
}
