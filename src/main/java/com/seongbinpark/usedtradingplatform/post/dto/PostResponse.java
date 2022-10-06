package com.seongbinpark.usedtradingplatform.post.dto;

import com.seongbinpark.usedtradingplatform.member.entity.Address;
import com.seongbinpark.usedtradingplatform.member.entity.Location;
import com.seongbinpark.usedtradingplatform.post.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class PostResponse {

    private final Long id;
    private final String title;
    private final String author;
    private final String email;
    private final String content;

    private final String status;
    private final String category;

    private final Address address;
    private final Location location;

    private final LocalDateTime createdTime;
    private final LocalDateTime modifiedTime;

    public static PostResponse of(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .author(post.getAuthor().getNickname())
                .email(post.getAuthor().getEmail())
                .content(post.getContent())
                .status(post.getStatus().getTradeStatus())
                .category(post.getCategory().getCategoryName())
                .address(post.getAddress())
                .location(post.getLocation())
                .build();
    }
}
