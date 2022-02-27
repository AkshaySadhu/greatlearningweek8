package com.greatlearning.week8.repository;

import com.greatlearning.week8.Model.Cart;
import com.greatlearning.week8.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface cartRepository extends JpaRepository<Cart, Integer> {
    Cart findCartByUser(User user);
}
