package com.example.demo.Implements.AllUser;

import com.example.demo.Interfaces.AllUser.ProductInterface;
import com.example.demo.Repository.AllUser.ProductRepo;
import com.example.demo.entity.AllUser.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInterfaceImpl implements ProductInterface {
    @Autowired
    private ProductRepo productRepo;


    @Override
    public List<Product> getSomeProductUsingCategory(int size ,String category) {
        return productRepo.getSomeProduct(size ,category);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getOneProduct(String id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllUserProducts(String phone) {
        return productRepo.findAllByUser_Phone(phone);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }
}
