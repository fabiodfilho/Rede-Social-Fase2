package com.example.rsocial2.Service;

import com.example.rsocial2.Model.Post;
import com.example.rsocial2.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findRecentPosts() {

        return postRepository.findAllByOrderByCreationDateDesc();
    }

    @Override
    public List<Post> findPostsByAuthorId(Long authorId) {
        return postRepository.findAllByAuthorIdOrderByCreationDateDesc(authorId);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }



}

