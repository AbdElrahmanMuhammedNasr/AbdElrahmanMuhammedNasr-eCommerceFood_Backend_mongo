package com.example.demo.Implements.Cart;

import com.example.demo.Interfaces.Cart.CartInterface;
import com.example.demo.Repository.Cart.CartRepository;
import com.example.demo.entity.Cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartInterfaceImpl implements CartInterface {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllUserCarts(String phone) {
        return cartRepository.findAllByUser_Phone(phone);
    }
}
