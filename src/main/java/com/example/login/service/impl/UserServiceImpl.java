package com.example.login.service.impl;

import com.example.common.CommonCode;
import com.example.login.dao.UserMapper;
import com.example.login.domain.User;
import com.example.login.response.LoginPageResult;
import com.example.login.service.UserService;
import com.example.login.response.LoginCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

    @Override
    public LoginPageResult findUserByUsername(User user) {
        User userByUsername = userMapper.findUserByUsername(user.getUsername());
        if(null == userByUsername || !(user.getPassword()).equals(userByUsername.getPassword())){
            LoginPageResult responseResult=new LoginPageResult(LoginCode.LOGIN_ERROR_FAILSEPASSEORD,null);
            return responseResult;
        }
        return new LoginPageResult(CommonCode.SUCCESS,null);
    }
}
