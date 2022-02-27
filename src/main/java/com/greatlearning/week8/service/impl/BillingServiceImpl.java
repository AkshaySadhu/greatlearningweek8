package com.greatlearning.week8.service.impl;

import com.greatlearning.week8.Model.Cart;
import com.greatlearning.week8.Model.Items;
import com.greatlearning.week8.Model.User;
import com.greatlearning.week8.repository.ItemsRepository;
import com.greatlearning.week8.repository.cartRepository;
import com.greatlearning.week8.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingServiceImpl implements BillingService {

    @Autowired
    private cartRepository cartRepository;

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public Double getTotalBillAmount(User user) {
        Cart cart1 =  cartRepository.findCartByUser(user);
        Double billAmount = 0.0;
        for(Items items : cart1.getItemsList()){
            billAmount += items.getItemPrice();
        }

        return billAmount;
    }

    @Override
    public void displayBill(User user) {
        Cart cart = cartRepository.findCartByUser(user);
        cart.getItemsList().forEach(item -> {
            System.out.println(item.getItemName() + "   :    " + item.getItemPrice());
        });
    }

    @Override
    public void createCartForUser(List<Items> itemsList, User user) {
        Cart cart = new Cart(user, itemsList);
        cartRepository.save(cart);
        System.out.println("Cart saved");
    }

    @Override
    public void updateCart(User user, List<Items> itemsList) {
        Cart cart = cartRepository.findCartByUser(user);
        cart.setItemsList(itemsList);
        cartRepository.save(cart);
    }

    @Override
    public boolean ifCartExistsForUser(User user){
        Cart cart = cartRepository.findCartByUser(user);
        if(cart != null){
            return true;
        }
        return false;
    }

    @Override
    public List<Items> getItemsForUser(User user) {
        Cart cart = cartRepository.findCartByUser(user);
        return cart.getItemsList();
    }


}
