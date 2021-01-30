package com.example.login.service;

import com.example.login.domain.User;
import com.example.login.response.LoginPageResult;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();

    public LoginPageResult findUserByUsername(User user);

}
