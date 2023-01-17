package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeList {

    private int age;

    private List<Employee> list;

    public EmployeeList(List<Employee> list){
        this.list = list;
    }


}
