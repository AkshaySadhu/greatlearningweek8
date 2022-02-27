package com.greatlearning.week8.controller;

import com.greatlearning.week8.Model.Items;
import com.greatlearning.week8.Model.User;
import com.greatlearning.week8.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class BillingController {

    @Autowired
    private BillingService billingService;

    @PostMapping("/add_to_cart")
    public String addToCart(Items items, User user){
        if(billingService.ifCartExistsForUser(user)){
            List<Items> itemsList = billingService.getItemsForUser(user);
            itemsList.add(items);
            billingService.updateCart(user, itemsList);
        }else{
            List<Items> itemsList = Collections.singletonList(items);
            billingService.createCartForUser(itemsList, user);
        }
        return "Item added to cart";
    }

    @GetMapping("/get_bill_amount")
    public Double getBillForUser(User user){
        Double billAmount = billingService.getTotalBillAmount(user);
        return billAmount;
    }

    @GetMapping("/display_bill")
    public void displayBill(User user){
        billingService.displayBill(user);
    }
}
