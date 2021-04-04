package com.example.demo.Controller.AllUser;

import com.example.demo.Interfaces.AllUser.CommentInterface;
import com.example.demo.Interfaces.AllUser.UserInterface;
import com.example.demo.entity.AllUser.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentInterface commentInterface;
    @Autowired
    private UserInterface userInterface;

    @RequestMapping(value = "/add-comment", method = RequestMethod.POST)
    public ResponseEntity<Comment> addPost(@RequestBody Comment comment) {

        comment.setCreated(new Date());
        comment.setCoUserId(userInterface.getUserData("01205338791"));
        comment.setUser(userInterface.getUserData("01200000000"));
        commentInterface.addNewComment(comment);

        return new ResponseEntity<>(comment, HttpStatus.OK);

    }

    @RequestMapping(value = "/delete-comment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Comment> deletePost(@PathVariable("id") String id) {

        commentInterface.deleteComment(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
