package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.post.domain.entity.Post;
import com.seongbinpark.usedtradingplatform.post.dto.PostRequest;

public interface PostService {

    public void createNewPost(PostRequest postRequest, Member member);

    public Post findPostById(Long postId);
}
