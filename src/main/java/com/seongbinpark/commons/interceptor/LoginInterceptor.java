package com.seongbinpark.commons.interceptor;

import com.seongbinpark.commons.annotation.LoginRequired;
import com.seongbinpark.usedtradingplatform.member.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class LoginInterceptor implements HandlerInterceptor {

    private final LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod && ((HandlerMethod) handler)
                .hasMethodAnnotation(LoginRequired.class)) {
            Long memberId = loginService.getLoginMemberId();

            if (memberId == null) {
                //예외 처리
            }
        }
        return true;
    }
}