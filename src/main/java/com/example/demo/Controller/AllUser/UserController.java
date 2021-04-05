package com.example.demo.Controller.AllUser;

import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.entity.AllUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserInterface userInterface;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user){

        Map<String ,Integer> meta = new HashMap();
        meta.put("rating",0);
        meta.put("product",0);
        meta.put("client",0);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMeta(meta);
        user.setCreated(new Date());

        User user_created = userInterface.addNewUser(user);
        return new ResponseEntity<>(user_created , HttpStatus.OK);

    }

    @RequestMapping(value = "/get-user/{phone}", method = RequestMethod.GET)
    public ResponseEntity<User> getOneUser(@PathVariable("phone") String phone){

        User user_returned = userInterface.getUserData(phone);
        return new ResponseEntity<>(user_returned , HttpStatus.OK);

    }

    @RequestMapping(value = "/delete-user/{phone}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable("phone") String phone){
         userInterface.deleteUser(phone);
        return new ResponseEntity<>( HttpStatus.OK);

    }

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User user_updated = userInterface.updateUser(user);
        return new ResponseEntity<>(user_updated, HttpStatus.OK);

    }
}
