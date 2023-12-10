package com.example.rsocial2.Service;

import com.example.rsocial2.Model.Post;

import java.util.List;

public interface PostService {
    List<Post> findAllPosts();
    Post save(Post post);

}



