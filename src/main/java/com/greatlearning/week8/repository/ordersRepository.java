package com.greatlearning.week8.repository;

import com.greatlearning.week8.Model.Orders;
import com.greatlearning.week8.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ordersRepository extends JpaRepository<Orders, Integer> {

    List<Orders> getOrdersByUser(User user);
    List<Orders> getOrdersByDateOfPurchaseBetweenAndUser(User user, LocalDate startDate, LocalDate endDate);
    List<Orders> getOrdersByDateOfPurchaseBetween(LocalDate startDate, LocalDate endDate);
    List<Orders> getOrdersByOrderValueBetween(User user, Double startRange, Double endRange);
    List<Orders> getOrdersByUserIn(List<User> userList);
}
