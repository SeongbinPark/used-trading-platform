package com.seongbinpark.usedtradingplatform.post.controller;

import com.seongbinpark.usedtradingplatform.commons.annotation.LoginMember;
import com.seongbinpark.usedtradingplatform.commons.annotation.LoginRequired;
import com.seongbinpark.usedtradingplatform.member.entity.Member;
import com.seongbinpark.usedtradingplatform.post.dto.PostPageResponse;
import com.seongbinpark.usedtradingplatform.post.service.PostSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/searches")
public class PostSearchController {

    private final PostSearchService postSearchService;

    @LoginRequired
    @GetMapping
    public ResponseEntity<PostPageResponse> getPosts(@LoginMember Member member, Pageable pageable) {

        PostPageResponse page = postSearchService.findAllByMemberAddress(member, pageable);

        return ResponseEntity.ok(page);
    }
}
