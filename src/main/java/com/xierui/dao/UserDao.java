package com.xierui.dao;

import com.xierui.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from user")
    public List<User> findUser();

    @Insert("insert into user values(#{id},#{name},#{gender},#{age})")
    public void saveUser(User user);
}
