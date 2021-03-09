package com.vmms.login.controller;

import com.vmms.common.CommonCode;
import com.vmms.common.ResponseResult;
import com.vmms.login.domain.User;
import com.vmms.login.response.LoginPageResult;
import com.vmms.login.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ResponseResult login(@RequestBody User user){
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        LoginPageResult userByUsername = new LoginPageResult(CommonCode.SUCCESS,userDetails);
        return userByUsername;
    }
}
