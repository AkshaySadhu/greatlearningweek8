package com.greatlearning.week8.service;

import com.greatlearning.week8.Model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    void delete(String username);

    void updateUser(User user);

    List<User> getAllUsersByCity(String city);
}
