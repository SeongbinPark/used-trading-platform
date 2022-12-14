package com.seongbinpark.usedtradingplatform.member.controller;


import com.seongbinpark.usedtradingplatform.commons.annotation.LoginMember;
import com.seongbinpark.usedtradingplatform.commons.annotation.LoginRequired;
import com.seongbinpark.usedtradingplatform.member.entity.Member;
import com.seongbinpark.usedtradingplatform.member.dto.*;
import com.seongbinpark.usedtradingplatform.member.service.LoginService;
import com.seongbinpark.usedtradingplatform.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.seongbinpark.usedtradingplatform.commons.HttpStatusResponseEntity.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final LoginService loginService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<HttpStatus> registration(@RequestBody @Valid Member member) {
        memberService.registrationMember(member);
        return RESPONSE_CREATED;
    }


    @GetMapping("/duplicated/{email}")
    public ResponseEntity<HttpStatus> isDuplicatedEmail(@PathVariable String email) {
        boolean isDuplicated = memberService.isDuplicatedEmail(email);
        if (isDuplicated) {
            return RESPONSE_CONFLICT;
        }

        return RESPONSE_OK;
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody @Valid MemberDto memberDto) {

        boolean isvalidMember = memberService.isValidMember(memberDto, passwordEncoder);
        if (isvalidMember) {
            loginService.login(memberService.findMemberByEmail(memberDto.getEmail()).getId());
            return RESPONSE_OK;
        }
        return RESPONSE_BAD_REQUEST;
    }

    @LoginRequired
    @GetMapping("/logout")
    public ResponseEntity<HttpStatus> logout() {
        loginService.logout();
        return RESPONSE_OK;
    }

    @LoginRequired
    @GetMapping("/my-profile")
    public ResponseEntity<ProfileResponse> getMemberProfile(@LoginMember Member member) {
        return ResponseEntity.ok(ProfileResponse.of(member));
    }

    @LoginRequired
    @PutMapping("/my-profile")
    public ResponseEntity<ProfileResponse> updateMemberProfileNickname(@LoginMember Member member, @RequestBody ProfileRequest profileRequest) {
        memberService.updateMemberProfileNickname(member, profileRequest);

        return ResponseEntity.ok(ProfileResponse.of(member));
    }

    @LoginRequired
    @PutMapping("/password")
    public ResponseEntity<HttpStatus> changePassword(@LoginMember Member member, @RequestBody @Valid PasswordRequest passwordRequest) {
        if (memberService.isValidPassword(member, passwordRequest, passwordEncoder)) {
            memberService.updateMemberPassword(member, passwordRequest, passwordEncoder);
        }

        return RESPONSE_OK;
    }

    @LoginRequired
    @PutMapping("/my-location")
    public ResponseEntity<HttpStatus> setMemberLocationAddress(@LoginMember Member member, @RequestBody LocationAddressRequest locationAddressRequest) {

        memberService.setMemberLocationAddress(member, locationAddressRequest);

        return RESPONSE_OK;
    }
}
