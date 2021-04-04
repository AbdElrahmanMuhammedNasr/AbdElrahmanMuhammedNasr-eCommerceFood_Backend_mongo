package com.example.demo.Repository.AllUser;

import com.example.demo.entity.AllUser.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends MongoRepository<Comment, String> {
}
