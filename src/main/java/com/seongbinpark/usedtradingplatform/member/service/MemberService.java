package com.seongbinpark.usedtradingplatform.member.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;

public interface MemberService {

    public void registrationMember(Member member);

    public boolean isDuplicatedEmail(String email);

}
