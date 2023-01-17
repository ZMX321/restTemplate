package com.example.demo.Service.impl;

import com.example.demo.Service.EmployeeService;
import com.example.demo.pojo.Employee;
import com.example.demo.pojo.EmployeeList;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private RestTemplate restTemplate;


    private static final String baseUrl = "https://dummy.restapiexample.com/api/v1/employees";

    @Autowired
    public EmployeeServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public List<EmployeeList> getEmpInAscByAge() {
        EmployeeList el = restTemplate.getForObject(baseUrl, EmployeeList.class);
        TreeMap<Integer,List<Employee>> tMap = processEmpList(el);
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
        TreeMap<Integer,List<Employee>> tMap = processEmpList(el);
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


    public TreeMap<Integer, List<Employee>> processEmpList(EmployeeList list){
        TreeMap<Integer, List<Employee>> tMap = new TreeMap<>();
        List<Employee> le = list.getList();

        for(Employee e : le){
            if(!tMap.containsKey(e.getEmployee_age())){
                tMap.put(e.getEmployee_age(), new LinkedList<>());
            }
            tMap.get(e.getEmployee_age()).add(e);
        }

        return tMap;
    }




}
