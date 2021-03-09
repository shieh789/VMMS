package com.vmms.login.dao;

import com.vmms.login.domain.Role;
import com.vmms.login.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User loadUserByUsername(String username);

    List<Role> getUserRolesByUid(Integer uid);
}
