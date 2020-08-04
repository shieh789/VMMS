package com.xierui.controller;

import com.xierui.domain.User;
import com.xierui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/findUser")
    public String findUser(Model model){
        List<User> user = userService.findUser();
        model.addAttribute("list",user);
        return "list";
    }

    @RequestMapping("/saveUser")
    public String addUser(){
        User user=new User();
        user.setAge(20);
        user.setId(1);
        user.setGender("2");
        user.setName("java");
        userService.saveUser(user);
        return "list";
    }
}
