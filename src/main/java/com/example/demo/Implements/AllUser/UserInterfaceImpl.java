package com.example.demo.Implements.AllUser;

import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.Repository.AllUser.UserRepo;
import com.example.demo.entity.AllUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInterfaceImpl implements UserInterface {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUserData(String phone) {
        return userRepo.findByPhone(phone);
    }

    @Override
    public User addNewUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String phone) {

    }
}
