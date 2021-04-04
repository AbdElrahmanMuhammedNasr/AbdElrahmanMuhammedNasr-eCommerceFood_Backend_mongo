package com.example.demo.Controller.AllUser;

import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.entity.AllUser.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserInterface userInterface;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(){

        List<String> list = new ArrayList<>();
        list.add("Facebook");
        list.add("youtube");

        Map <String, Integer> map = new HashMap<>();
        map.put("Product",5);
        map.put("Client",200);
        map.put("Rating",10);

        User user = new User();
        user.setImage( new byte[]{1, 2,3,4,5,6,9,7});
        user.setPhone("01205338791");
        user.setFullName("Abdo");
        user.setJob("car");
        user.setAbout("this is");
        user.setLinks(list);
        user.setMeta(map);
        user.setState("Cairo");
        user.setCity("tanta");
        user.setStreet("kafr");
        user.setCreated(new Date());

        User user_created = userInterface.addNewUser(user);
        return new ResponseEntity<>(user_created , HttpStatus.OK);

    }

    @RequestMapping(value = "/get-user/{phone}", method = RequestMethod.GET)
    public ResponseEntity<User> getOneUser(@PathVariable("phone") String phone){

        User user_returned = userInterface.getUserData(phone);
        return new ResponseEntity<>(user_returned , HttpStatus.OK);

    }
}
