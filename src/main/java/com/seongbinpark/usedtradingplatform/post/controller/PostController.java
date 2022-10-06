package com.seongbinpark.usedtradingplatform.post.controller;

import com.seongbinpark.usedtradingplatform.commons.annotation.LoginMember;
import com.seongbinpark.usedtradingplatform.commons.annotation.LoginRequired;
import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.post.dto.PostRequest;
import com.seongbinpark.usedtradingplatform.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.seongbinpark.usedtradingplatform.commons.HttpStatusResponseEntity.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @LoginRequired
    @PostMapping
    public ResponseEntity<HttpStatus> createNewPost(@RequestBody @Valid PostRequest postRequest, @LoginMember Member member) {
        postService.createNewPost(postRequest, member);
        return RESPONSE_CREATED;
    }


}
