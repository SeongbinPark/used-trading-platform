package com.seongbinpark.usedtradingplatform.member.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.member.dto.MemberDto;

public interface LoginService {

    public void login(long id);

    public Long getLoginMemberId();

    public void logout();

    public Member getLoginMember();

}
