package com.seongbinpark.usedtradingplatform.post.service;

import com.seongbinpark.usedtradingplatform.member.entity.Member;
import com.seongbinpark.usedtradingplatform.post.dto.PostPageResponse;
import org.springframework.data.domain.Pageable;

public interface PostSearchService {

    public PostPageResponse findAllByMemberAddress(Member member, Pageable pageable);
}
