package com.example.demo.Repository.Cart;

import com.example.demo.entity.Cart.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    List<Cart> findAllByUser_Phone(String phone);
}
