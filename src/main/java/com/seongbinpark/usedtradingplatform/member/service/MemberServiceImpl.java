package com.seongbinpark.usedtradingplatform.member.service;

import com.seongbinpark.usedtradingplatform.member.domain.entity.Member;
import com.seongbinpark.usedtradingplatform.member.dto.MemberDto;
import com.seongbinpark.usedtradingplatform.member.dto.ProfileRequest;
import com.seongbinpark.usedtradingplatform.member.exception.MemberNotFoundException;
import com.seongbinpark.usedtradingplatform.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void registrationMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public boolean isDuplicatedEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public Member findMemberByEmail(String email) {
        return memberRepository.findMemberByEmail(email).orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public Member findMemberById(long id) {
        return memberRepository.findMemberById(id).orElseThrow(MemberNotFoundException::new);
    }

    @Override
    public boolean isValidMember(MemberDto memberDto, PasswordEncoder passwordEncoder) {
        Member member = findMemberByEmail(memberDto.getEmail());
        if (passwordEncoder.matches(memberDto.getPassword(), member.getPassword())) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void updateMemberProfileNickname(Member member, ProfileRequest profileRequest) {
        member.updateProfileNickname(profileRequest.getNickname());
    }
}
