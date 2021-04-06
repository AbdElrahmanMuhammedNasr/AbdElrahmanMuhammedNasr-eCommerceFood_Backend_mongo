package com.example.demo.Controller.AllUser;

import com.example.demo.Interfaces.AllUser.PostInterface;
import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.entity.AllUser.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostInterface postInterface;
    @Autowired
    private UserInterface userInterface;

    @RequestMapping(value = "/add-post", method = RequestMethod.POST)
    public ResponseEntity<Post> addPost(@RequestBody Post post) {

        post.setCreated(new Date());
        post.setUser(userInterface.getUserData("01550449049"));
        postInterface.addNewPost(post);

        return new ResponseEntity<>(post, HttpStatus.OK);

    }

    @RequestMapping(value = "/update-post", method = RequestMethod.PUT)
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {

        postInterface.updatePost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);

    }

    @RequestMapping(value = "/delete-post/{id}", method = RequestMethod.POST)
    public ResponseEntity<Post> deletePost(@PathVariable("id") String id) {

        postInterface.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
