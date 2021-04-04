package com.example.demo.Interfaces.Cart;

import com.example.demo.entity.Cart.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartInterface {

    List<Cart> getAllUserCarts(String phone);
    Cart addToCart(Cart cart);
}
