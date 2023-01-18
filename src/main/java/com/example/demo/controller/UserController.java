package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.pojo.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        UserList l = userService.getAllUsers();
        return new ResponseEntity(l, HttpStatus.OK);
    }

}
