package com.seongbinpark.usedtradingplatform.commons.advice;

import com.seongbinpark.usedtradingplatform.member.exception.MemberNotFoundException;
import com.seongbinpark.usedtradingplatform.member.exception.UnauthenticatedAccessException;
import com.seongbinpark.usedtradingplatform.post.exception.AreaInfoNotDefinedException;
import org.apache.coyote.Response;
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

    @ExceptionHandler(AreaInfoNotDefinedException.class)
    public ResponseEntity<HttpStatus> areaInfoNotDefinedException(AreaInfoNotDefinedException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
    }
}
