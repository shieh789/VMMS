package com.example.login.domain;

import lombok.Data;

@Data
public class User {
    String id;
    String username;
    String password;
    Integer age;
    String address;
    String salary;
}
