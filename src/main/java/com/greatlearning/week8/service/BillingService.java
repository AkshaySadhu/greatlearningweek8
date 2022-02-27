package com.greatlearning.week8.service;

import com.greatlearning.week8.Model.Cart;
import com.greatlearning.week8.Model.Items;
import com.greatlearning.week8.Model.User;

import java.util.List;

public interface BillingService {
    Double getTotalBillAmount(User user);

    void displayBill(User user);

    void createCartForUser(List<Items> itemsList, User user);

    void updateCart(User user, List<Items> itemsList);

    boolean ifCartExistsForUser(User user);

    List<Items> getItemsForUser(User user);
}
