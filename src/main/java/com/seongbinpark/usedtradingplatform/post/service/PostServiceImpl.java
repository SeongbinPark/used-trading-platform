package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.post.domain.entity.Category;
import com.seongbinpark.usedtradingplatform.post.domain.entity.Post;
import com.seongbinpark.usedtradingplatform.post.dto.PostRequest;
import com.seongbinpark.usedtradingplatform.post.exception.CategoryNotFoundException;
import com.seongbinpark.usedtradingplatform.post.exception.PostNotFoundException;
import com.seongbinpark.usedtradingplatform.post.repository.CategoryRepository;
import com.seongbinpark.usedtradingplatform.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void createNewPost(PostRequest postRequest, Member member) {
        Post post = postRequest.toEntity(member);
        postRepository.save(post);
    }

    @Override
    public Post findPostById(Long postId) {
        return postRepository.findPostById(postId).orElseThrow(PostNotFoundException::new);
    }

    @Override
    @Transactional
    public void updatePost(Post post, PostRequest postRequest) {
        Category category = categoryRepository.findCategoryByName(post.getCategory().getCategoryName())
                .orElseThrow(() -> new CategoryNotFoundException(postRequest.getCategoryName()));

        post.updatePost(postRequest);
        post.setCategory(category);
    }
}
