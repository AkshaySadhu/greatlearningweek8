package com.greatlearning.week8.service.impl;

import com.greatlearning.week8.Constants.Constants;
import com.greatlearning.week8.Model.Orders;
import com.greatlearning.week8.Model.User;
import com.greatlearning.week8.repository.ordersRepository;
import com.greatlearning.week8.service.OrdersService;
import com.greatlearning.week8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private ordersRepository ordersRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<Orders> getAllOrdersForUser(User user) {
        if("USER".equals(user.getRoles())) {
            return ordersRepository.getOrdersByUser(user);
        }
        return null;
    }

    @Override
    public List<Orders> getOrdersByPriceRangeForUser(User user, Double startRange, Double endRange) {
        if("USER".equals(user.getRoles())) {
            return ordersRepository.getOrdersByOrderValueBetween(user, startRange, endRange);
        }
        return null;
    }

    @Override
    public List<Orders> getOrdersByDateRangeForUser(User user, LocalDate startDate, LocalDate endDate) {
        if("USER".equals(user.getRoles())) {
            return ordersRepository.getOrdersByDateOfPurchaseBetweenAndUser(user, startDate, endDate);
        }
        return null;
    }

    @Override
    public List<Orders> getOrdersByCity_admin(User user, String city) {
        if("ADMIN".equals(user.getRoles())) {
            List<User> userList = userService.getAllUsersByCity(city);
            List<Orders> ordersList = ordersRepository.getOrdersByUserIn(userList);
            return ordersList;
        }
        return null;
    }

    @Override
    public List<Orders> getOrdersOfPrevMonth_admin(User user, String month) {
        if("ADMIN".equals(user.getRoles())) {
            YearMonth yearMonth = YearMonth.of(Year.now().getValue(), Constants.monthsMap.get(month));
            LocalDate firstOfMonth = yearMonth.atDay(1);
            LocalDate last = yearMonth.atEndOfMonth();
            return ordersRepository.getOrdersByDateOfPurchaseBetween(firstOfMonth, last);
        }
        return null;
    }

    @Override
    public Map<String, List<Orders>> getOrdersOfPrevYear_admin(User user, Integer year) {
        if("ADMIN".equals(user.getRoles())) {
            Map<String, List<Orders>> resultMap = new HashMap<>();
            for (String month : Constants.monthsMap.keySet()) {
                YearMonth yearMonth = YearMonth.of(year, Constants.monthsMap.get(month));
                LocalDate firstOfMonth = yearMonth.atDay(1);
                LocalDate last = yearMonth.atEndOfMonth();
                List<Orders> ordersList = ordersRepository.getOrdersByDateOfPurchaseBetween(firstOfMonth, last);
                resultMap.put(month, ordersList);
            }
            return resultMap;
        }
        return null;
    }
}
