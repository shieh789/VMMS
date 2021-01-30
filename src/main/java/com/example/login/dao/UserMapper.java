package com.example.login.dao;

import com.example.login.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> getAllUser();

    public User findUserByUsername(String username);
}
