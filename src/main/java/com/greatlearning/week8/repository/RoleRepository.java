package com.greatlearning.week8.repository;

import com.greatlearning.week8.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
