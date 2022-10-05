package com.seongbinpark.usedtradingplatform.commons.advice;

import com.seongbinpark.usedtradingplatform.member.exception.MemberNotFoundException;
import com.seongbinpark.usedtradingplatform.member.exception.UnauthenticatedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.seongbinpark.usedtradingplatform.commons.HttpStatusResponseEntity.*;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<HttpStatus> memberNotFoundException() {
        return RESPONSE_NOT_FOUND;
    }

    @ExceptionHandler(UnauthenticatedAccessException.class)
    public ResponseEntity<HttpStatus> unauthenticatedAccessException() {
        return RESPONSE_UNAUTHORIZED;
    }
}
