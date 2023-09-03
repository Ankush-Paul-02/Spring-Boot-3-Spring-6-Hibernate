package com.devmare.springjwtauth.service;

import com.devmare.springjwtauth.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    public UserService() {
        userList.add(new User(UUID.randomUUID().toString(), "Ankush", "ankush@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Sid", "sid@gmail.com"));
        userList.add(new User(UUID.randomUUID().toString(), "Deepon", "deepon@gmail.com"));
    }

    private final List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return this.userList;
    }
}
