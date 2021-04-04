package com.example.demo.Repository.AllUser;

import com.example.demo.entity.AllUser.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends MongoRepository<Post, String> {
}
