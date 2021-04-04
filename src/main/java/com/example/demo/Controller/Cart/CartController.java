package com.example.demo.Controller.Cart;

import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.Interfaces.Cart.CartInterface;
import com.example.demo.entity.Cart.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/cart")
public class CartController {


    @Autowired
    private UserInterface userInterface;

    @Autowired
    private CartInterface cartInterface;

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart){

        cart.setCreated(new Date());
        cart.setUser(userInterface.getUserData("01205338791"));

        Cart cart_created = cartInterface.addToCart(cart);
        return new ResponseEntity<>(cart_created , HttpStatus.OK);
    }

}
