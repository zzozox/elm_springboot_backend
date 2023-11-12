package com.example.elm_springboot_backend.entity;

import lombok.Data;

@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
}
