package com.seongbinpark.usedtradingplatform.member.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final HttpSession httpSession;
    public static final String MEMBER_ID = "MEMBER_ID";


    @Override
    public void login(long id) {
        httpSession.setAttribute(MEMBER_ID, id);
    }

    @Override
    public Long getLoginMemberId() {
        return (Long) httpSession.getAttribute(MEMBER_ID);
    }
}
