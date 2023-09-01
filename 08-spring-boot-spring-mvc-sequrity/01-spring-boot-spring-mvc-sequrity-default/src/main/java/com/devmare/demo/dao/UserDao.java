package com.devmare.demo.dao;

import com.devmare.demo.entity.User;

public interface UserDao {
    User findByUserName(String username);

    void save(User user);
}
