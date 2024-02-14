package com.fullstack.login.demo.services;

import com.fullstack.login.demo.entities.User;

public interface StudentService {
    User saveUser(User user);

    boolean authenticateUser(User user);
}
