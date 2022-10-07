package com.seongbinpark.usedtradingplatform.post.repository;

import com.seongbinpark.usedtradingplatform.post.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostSearchRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT p FROM Post p JOIN FETCH p.author WHERE p.address.state=:state AND p.address.city=:city AND p.address.town=:town",
            countQuery = "SELECT COUNT(*) FROM Post p WHERE p.address.state=:state AND p.address.city=:city AND p.address.town=:town")
    public Page<Post> findAllByMemberAddress(String state, String city, String town, Pageable pageable);

}
