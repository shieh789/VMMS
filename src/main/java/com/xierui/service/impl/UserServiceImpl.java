package com.xierui.service.impl;

import com.xierui.dao.UserDao;
import com.xierui.domain.User;
import com.xierui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findUser() {
        return userDao.findUser();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
