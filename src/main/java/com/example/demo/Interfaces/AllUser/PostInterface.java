package com.example.demo.Interfaces.AllUser;

import com.example.demo.entity.AllUser.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostInterface {

    List<Post> getSomeUserPost(String phone);
    Post addNewPost(Post post);
    Post updatePost(Post post);
    void deletePost(String id);
}
