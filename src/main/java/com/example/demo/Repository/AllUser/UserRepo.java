package com.example.demo.Repository.AllUser;

import com.example.demo.entity.AllUser.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

    User findByPhone(String phone);
}
