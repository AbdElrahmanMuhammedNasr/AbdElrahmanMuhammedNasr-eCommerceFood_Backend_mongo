package com.example.demo.Implements.AllUser;

import com.example.demo.Interfaces.AllUser.PostInterface;
import com.example.demo.Repository.AllUser.PostRepo;
import com.example.demo.entity.AllUser.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostInterfaceImpl implements PostInterface {
    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> getSomeUserPost(String phone) {
        return null;
    }

    @Override
    public Post addNewPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        return postRepo.save(post);

    }

    @Override
    public void deletePost(String id) {
        postRepo.deleteById(id);
    }
}
