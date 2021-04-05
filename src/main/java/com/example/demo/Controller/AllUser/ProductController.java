package com.example.demo.Controller.AllUser;

import com.example.demo.Interfaces.AllUser.ProductInterface;
import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.entity.AllUser.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @Autowired
    private UserInterface userInterface;


    @RequestMapping(value = "/get-products/{size}/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts(@PathVariable("size") int size, @PathVariable("category") String category) {

        List product_returned = productInterface.getSomeProductUsingCategory(size, category);

        return new ResponseEntity<>(product_returned, HttpStatus.OK);
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        String phone = SecurityContextHolder.getContext().getAuthentication().getCredentials().toString();

        product.setCreated(new Date());
        product.setUser(userInterface.getUserData(phone));
        productInterface.addProduct(product);

        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("id") String id) {

        Product product_returned = productInterface.getOneProduct(id);
        return new ResponseEntity<>(product_returned, HttpStatus.OK);

    }

    @RequestMapping(value = "/get-user-products/{phone}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getUserProducts(@PathVariable("phone") String phone) {

        List<Product> products_returned = productInterface.getAllUserProducts(phone);
        return new ResponseEntity<>(products_returned, HttpStatus.OK);

    }

    @RequestMapping(value = "/update-product", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product product_updated = productInterface.updateProduct(product);
        return new ResponseEntity<>(product_updated, HttpStatus.OK);

    }

    @RequestMapping(value = "/delete-product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") String id) {
        productInterface.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}






















