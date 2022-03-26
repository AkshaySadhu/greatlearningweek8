package com.greatlearning.week8.repository;


import com.greatlearning.week8.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    List<User> getAllByCity(String city);
}
