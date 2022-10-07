package com.seongbinpark.usedtradingplatform.member.service;

import com.seongbinpark.usedtradingplatform.member.entity.Member;

public interface LoginService {

    public void login(long id);

    public Long getLoginMemberId();

    public void logout();

    public Member getLoginMember();

}
