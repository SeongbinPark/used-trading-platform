package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.commons.annotation.AreaInfoRequired;
import com.seongbinpark.usedtradingplatform.member.entity.Address;
import com.seongbinpark.usedtradingplatform.member.entity.Member;
import com.seongbinpark.usedtradingplatform.post.dto.PostPageResponse;
import com.seongbinpark.usedtradingplatform.post.dto.PostResponse;
import com.seongbinpark.usedtradingplatform.post.entity.Post;
import com.seongbinpark.usedtradingplatform.post.repository.PostSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostSearchServiceImpl implements PostSearchService {

    private final PostSearchRepository postSearchRepository;

    @Override
    @AreaInfoRequired
    public PostPageResponse findAllByMemberAddress(Member member, Pageable pageable) {

        Address address = member.getAddress();
        Page<Post> posts = postSearchRepository.findAllByMemberAddress(address.getState(), address.getCity(), address.getTown(), pageable);

        List<PostResponse> postResponses = posts.getContent().stream().map(PostResponse::of).collect(Collectors.toList());

        return PostPageResponse.builder()
                .currentPage(pageable.getPageNumber())
                .totalPage(posts.getTotalPages())
                .postResponses(postResponses)
                .build();

    }
}
