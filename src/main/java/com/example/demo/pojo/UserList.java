package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserList {

    @JsonProperty("data")
    private List<User> list;
}
