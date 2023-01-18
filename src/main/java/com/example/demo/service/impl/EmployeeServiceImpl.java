package com.example.demo.service.impl;

import com.example.demo.service.EmployeeService;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private RestTemplate restTemplate;

    @Value("${user.rest.url}")
    private String baseUrl;

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<EmployeeList> getEmpInAscByAge() {
        EmployeeList el = restTemplate.getForObject(baseUrl, EmployeeList.class);
        Map<Integer,List<Employee>> tMap = processEmpList(el);
        List<EmployeeList> res = new LinkedList<>();

        for(Integer age : tMap.keySet()){
            res.add(new EmployeeList(age, tMap.get(age)));
        }

        return res;
    }

    @Override
    public List<Employee> getEmpGreaterAge(String requireAge) {
        Integer ra = Integer.parseInt(requireAge);
        EmployeeList el = restTemplate.getForObject(baseUrl, EmployeeList.class);
        Map<Integer,List<Employee>> tMap = processEmpList(el);
        List<Employee> res = new LinkedList<>();

        for(Integer age : tMap.keySet()){
            if(age > ra){
                List<Employee> list = tMap.get(age);
                for(Employee e : list){
                    res.add(e);
                }
            }

        }
        return res;
    }


    public Map<Integer, List<Employee>> processEmpList(EmployeeList list){

        Map<Integer, List<Employee>> tMap = list.getList().stream().collect(Collectors.groupingBy(Employee::getEmployee_age));

        return tMap;
    }




}
