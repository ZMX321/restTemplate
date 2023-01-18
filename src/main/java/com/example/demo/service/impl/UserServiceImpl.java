package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import com.example.demo.pojo.UserList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Value("${user.rest.url}")
    private String url;

    @Autowired
    public UserServiceImpl(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public UserList getAllUsers() {
        UserList l = restTemplate.getForObject(url, UserList.class);

        return l;
    }
}
