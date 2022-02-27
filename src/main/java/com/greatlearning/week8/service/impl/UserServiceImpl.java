package com.greatlearning.week8.service.impl;

import com.greatlearning.week8.Model.User;
import com.greatlearning.week8.repository.RoleRepository;
import com.greatlearning.week8.repository.UserRepository;
import com.greatlearning.week8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void delete(String username) {
        User user = userRepository.findByUsername(username);
        userRepository.delete(user);
    }

    @Override
    public void updateUser(User user) {
        User userLocal = userRepository.findByUsername(user.getUsername());

        userLocal.setPassword(user.getPassword());
        userLocal.setEmail(user.getEmail());

        userRepository.save(userLocal);
    }
}
