package com.example.demo.Interfaces.AllUser;

import com.example.demo.entity.AllUser.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductInterface {

    List<Product> getSomeProductUsingCategory(int size ,String category);

    Product addProduct(Product product);

    Product getOneProduct(String id);

    List<Product> getAllUserProducts(String phone);

    void deleteProduct(String id);

    Product updateProduct(Product product);
}
