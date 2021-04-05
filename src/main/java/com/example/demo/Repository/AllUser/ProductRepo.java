package com.example.demo.Repository.AllUser;

import com.example.demo.entity.AllUser.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends MongoRepository<Product, String> {

    @Query(value = "{ '_id' : ?0 }", fields = "{}")
    Optional<Product> findById(String id);

    @Query(value = "{ 'pcategory': ?1 ,$sample: {size: ?0} }", fields = "{'user' :0 }")
    List<Product> getSomeProduct(int size, String category);

    //    get all user product
    @Query(value = "{}", fields = "{'user':0}")
    List<Product> findAllByUser_Phone(String phone);
}
