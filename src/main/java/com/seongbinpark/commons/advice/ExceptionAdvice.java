package com.seongbinpark.commons.advice;

import com.seongbinpark.commons.HttpStatusResponseEntity;
import com.seongbinpark.usedtradingplatform.member.exception.MemberNotFoundException;
import com.seongbinpark.usedtradingplatform.member.exception.UnauthenticatedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.seongbinpark.commons.HttpStatusResponseEntity.*;

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
