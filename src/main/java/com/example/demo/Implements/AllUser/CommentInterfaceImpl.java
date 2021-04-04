package com.example.demo.Implements.AllUser;

import com.example.demo.Interfaces.AllUser.CommentInterface;
import com.example.demo.Repository.AllUser.CommentRepo;
import com.example.demo.entity.AllUser.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentInterfaceImpl implements CommentInterface {

    @Autowired
    private CommentRepo commentRepo;
    @Override
    public List<Comment> getAllUserComments(String phone) {
        return null;
    }

    @Override
    public Comment addNewComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public void deleteComment(String id) {
        commentRepo.deleteById(id);

    }
}
