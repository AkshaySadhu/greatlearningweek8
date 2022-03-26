package com.greatlearning.week8.service;

import com.greatlearning.week8.Model.Orders;
import com.greatlearning.week8.Model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface OrdersService {

    List<Orders> getAllOrdersForUser(User user);

    List<Orders> getOrdersByPriceRangeForUser(User user, Double startRange, Double endRange);

    List<Orders> getOrdersByDateRangeForUser(User user, LocalDate startDate, LocalDate endDate);

    List<Orders> getOrdersByCity_admin(User user, String city);

    List<Orders> getOrdersOfPrevMonth_admin(User user, String month);

    Map<String, List<Orders>> getOrdersOfPrevYear_admin(User user, Integer year);
}
