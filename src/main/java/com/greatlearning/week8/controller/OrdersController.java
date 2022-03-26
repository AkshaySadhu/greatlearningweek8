package com.greatlearning.week8.controller;

import com.greatlearning.week8.Model.Orders;
import com.greatlearning.week8.Model.User;
import com.greatlearning.week8.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders/get_all")
    public List<Orders> getAllOrdersForUser(User user){
        return ordersService.getAllOrdersForUser(user);
    }

    @GetMapping("/orders/get_by_date_user")
    public List<Orders> getAllOrdersByDate(User user, LocalDate startDate, LocalDate endDate){
        return ordersService.getOrdersByDateRangeForUser(user, startDate, endDate);
    }

    @GetMapping("/orders/get_orders_by_value_user")
    public List<Orders> getAllOrdersByOrderValue(User user, Double startRange, Double endRange){
        return ordersService.getOrdersByPriceRangeForUser(user, startRange, endRange);
    }

    @GetMapping("/orders/get_orders_by_city")
    public List<Orders> getAllOrdersByCity_admin(User user, String city){
        return ordersService.getOrdersByCity_admin(user, city);
    }

    @GetMapping("/orders/get_orders_for_month")
    public List<Orders> getAllOrdersForMonth_admin(User user, String month){
        return ordersService.getOrdersOfPrevMonth_admin(user, month);
    }

    @GetMapping("/orders/get_orders_for_year_per_month")
    public Map<String, List<Orders>> getAllOrdersForYearPerMonth_admin(User user, Integer year){
        return ordersService.getOrdersOfPrevYear_admin(user, year);
    }
}
