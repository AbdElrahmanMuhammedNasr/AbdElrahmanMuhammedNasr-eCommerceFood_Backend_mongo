package com.example.demo.Interfaces.AllUser;

import com.example.demo.entity.AllUser.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentInterface {

    List<Comment> getAllUserComments(String phone);

    Comment addNewComment(Comment comment);

    void deleteComment(String id);

}
