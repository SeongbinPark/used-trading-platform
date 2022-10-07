package com.seongbinpark.usedtradingplatform.commons.advice;

import com.seongbinpark.usedtradingplatform.image.exception.UnsupportedFileTypeException;
import com.seongbinpark.usedtradingplatform.member.exception.MemberNotFoundException;
import com.seongbinpark.usedtradingplatform.member.exception.PasswordNotMatchedException;
import com.seongbinpark.usedtradingplatform.member.exception.UnauthenticatedAccessException;
import com.seongbinpark.usedtradingplatform.post.exception.AreaInfoNotDefinedException;
import com.seongbinpark.usedtradingplatform.post.exception.PostNotFoundException;
import com.seongbinpark.usedtradingplatform.post.exception.UnauthorizedAccessException;
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

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<HttpStatus> postNotFoundException() {
        return RESPONSE_NOT_FOUND;
    }

    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<HttpStatus> unauthorizedAccessException() {
        return RESPONSE_UNAUTHORIZED;
    }

    @ExceptionHandler(PasswordNotMatchedException.class)
    public ResponseEntity<HttpStatus> passwordNotMatchedException() {
        return RESPONSE_BAD_REQUEST;
    }

    @ExceptionHandler(UnsupportedFileTypeException.class)
    public ResponseEntity<HttpStatus> unsupportedFileTypeException() {
        return RESPONSE_BAD_REQUEST;
    }
}
