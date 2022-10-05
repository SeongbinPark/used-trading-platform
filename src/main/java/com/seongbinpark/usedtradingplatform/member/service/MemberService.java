package com.seongbinpark.usedtradingplatform.member.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.member.dto.MemberDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService {

    public void registrationMember(Member member);

    public boolean isDuplicatedEmail(String email);

    public Member findMemberByEmail(String email);

    public Member findMemberById(long id);
    public boolean isValidMember(MemberDto memberDto, PasswordEncoder passwordEncoder);

}
