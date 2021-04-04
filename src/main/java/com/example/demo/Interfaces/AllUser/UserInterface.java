package com.example.demo.Interfaces.AllUser;

import com.example.demo.entity.AllUser.User;
import org.springframework.stereotype.Service;

@Service
public interface UserInterface {

    User getUserData(String phone);

    User addNewUser(User user);

    User updateUser(User user);

    void deleteUser(String phone);


}
