package com.seongbinpark.usedtradingplatform.member.exception;

public class UnauthenticatedAccessException extends RuntimeException {

    public UnauthenticatedAccessException() {
        super();
    }

    public UnauthenticatedAccessException(String message) {
        super(message);
    }

    public UnauthenticatedAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
