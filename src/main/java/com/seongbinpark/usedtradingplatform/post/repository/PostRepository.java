package com.seongbinpark.usedtradingplatform.post.repository;

import com.seongbinpark.usedtradingplatform.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p WHERE p.id = :postId AND p.removed = false")
    public Optional<Post> findPostById(Long id);
}
