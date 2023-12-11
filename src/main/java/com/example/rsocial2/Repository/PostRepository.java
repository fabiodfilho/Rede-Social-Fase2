package com.example.rsocial2.Repository;

import com.example.rsocial2.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByOrderByCreationDateDesc();
    List<Post> findAllByAuthorIdOrderByCreationDateDesc(Long authorId);
}


