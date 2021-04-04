package com.example.demo.zTest;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Repo extends MongoRepository<Entity,String> {

    @Query(value="{ '_id' : ?0 }", fields="{'name' : 1, 'links' : 1 , '_id' : 1}")
    List findAllById(String id);
}
