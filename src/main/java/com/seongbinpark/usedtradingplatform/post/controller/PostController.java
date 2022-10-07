package com.seongbinpark.usedtradingplatform.post.controller;

import com.seongbinpark.usedtradingplatform.commons.annotation.AreaInfoRequired;
import com.seongbinpark.usedtradingplatform.commons.annotation.LoginMember;
import com.seongbinpark.usedtradingplatform.commons.annotation.LoginRequired;
import com.seongbinpark.usedtradingplatform.member.entity.Member;
import com.seongbinpark.usedtradingplatform.post.dto.PostRequest;
import com.seongbinpark.usedtradingplatform.post.dto.PostResponse;
import com.seongbinpark.usedtradingplatform.post.entity.Post;
import com.seongbinpark.usedtradingplatform.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.seongbinpark.usedtradingplatform.commons.HttpStatusResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @LoginRequired
    @PostMapping
    @AreaInfoRequired
    public ResponseEntity<HttpStatus> createPost(@RequestBody @Valid PostRequest postRequest, @LoginMember Member member) {
        postService.createNewPost(postRequest, member);
        return RESPONSE_CREATED;
    }

    @LoginRequired
    @GetMapping("{/postId}")
    public ResponseEntity<PostResponse> findPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(PostResponse.of(postService.findPostById(postId)));
    }

    @LoginRequired
    @PutMapping("/{postId}")
    public ResponseEntity<HttpStatus> updatePost(@Valid @RequestBody PostRequest postRequest,
                                                 @PathVariable Long postId) {
        Post post = postService.findPostById(postId);

        postService.updatePost(post, postRequest);
        return RESPONSE_OK;
    }
}
