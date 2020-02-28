package com.lau.community.exception;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-28
 * @description ：
 * @version: 1.0
 */
public class CustomizeException extends RuntimeException {
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }
}
