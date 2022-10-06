package com.seongbinpark.usedtradingplatform.post.repository;

import com.seongbinpark.usedtradingplatform.post.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface PostRepository extends JpaRepository<Post, Long> {

    public Optional<Post> findPostById(Long id);
}
