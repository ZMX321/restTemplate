package com.example.demo.service;

import com.example.demo.pojo.UserList;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserList getAllUsers();
}
