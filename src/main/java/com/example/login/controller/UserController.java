package com.example.login.controller;

import com.example.common.ResponseResult;
import com.example.login.domain.User;
import com.example.login.response.LoginPageResult;
import com.example.login.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping("/getAll")
    public List<User> getAll(@RequestBody User user){
        return userService.getAllUser();
    }

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        LoginPageResult userByUsername = userService.findUserByUsername(user);
        return userByUsername;
    }
}
