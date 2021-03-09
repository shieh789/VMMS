package com.vmms.login.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User implements UserDetails {
    private Integer id;
    private String username;
    private String password;
    private Integer enabled;
    private Integer locked;
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole_name()));
        }
        return authorities;
    }

    //判断账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    //判断账户是否被锁
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }
    //当前账户密码是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
    //判断当前账户是否可用
    @Override
    public boolean isEnabled() {
        return false;
    }
}
