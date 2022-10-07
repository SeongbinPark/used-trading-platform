package com.seongbinpark.usedtradingplatform.image.exception;

public class UnsupportedFileTypeException extends RuntimeException {

    public UnsupportedFileTypeException() {
        super();
    }

    public UnsupportedFileTypeException(String message) {
        super(message);
    }

    public UnsupportedFileTypeException(String message, Throwable cause) {
        super(message, cause);
    }
}
