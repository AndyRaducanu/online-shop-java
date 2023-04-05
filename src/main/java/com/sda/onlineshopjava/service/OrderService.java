package com.sda.onlineshopjava.service;

import com.sda.onlineshopjava.entityes.Cart;
import com.sda.onlineshopjava.entityes.CartEntry;
import com.sda.onlineshopjava.entityes.Order;
import com.sda.onlineshopjava.repository.CartEntryRepository;
import com.sda.onlineshopjava.repository.CartRepository;
import com.sda.onlineshopjava.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartEntryRepository cartEntryRepository;
    public void placeOrder(String loggedInUserEmail){
        Cart cart = cartRepository.findByUserAccountEmail(loggedInUserEmail);
        Order order = new Order();
        order.setUserAccount(cart.getUserAccount());
//        order.setCartEntryList(cart.getCartEntryList());
        orderRepository.save(order);
        for (CartEntry cartEntry: cart.getCartEntryList()){
            cartEntry.setCart(null);
            cartEntry.setOrder(order);
            cartEntryRepository.save(cartEntry);
        }
    }

}
