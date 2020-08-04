package com.xierui.service;

import com.xierui.domain.User;

import java.util.List;

public interface UserService {

    public List<User> findUser();

    public void saveUser(User user);
}
