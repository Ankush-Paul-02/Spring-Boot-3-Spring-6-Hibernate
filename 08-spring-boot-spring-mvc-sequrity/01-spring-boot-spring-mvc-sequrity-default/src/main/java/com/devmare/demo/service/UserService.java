package com.devmare.demo.service;

import com.devmare.demo.entity.User;
import com.devmare.demo.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);

    void save(WebUser webUser);
}
