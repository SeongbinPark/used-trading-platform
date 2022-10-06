package com.seongbinpark.usedtradingplatform.post.repository;

import com.seongbinpark.usedtradingplatform.post.domain.entity.Post;
import com.seongbinpark.usedtradingplatform.post.dto.PostRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long> {


}
