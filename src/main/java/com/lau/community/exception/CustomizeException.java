package com.lau.community.exception;

/**
 * @author ：lauchun
 * @date ：Created in 2020-02-28
 * @description ：
 * @version: 1.0
 */
public class CustomizeException extends RuntimeException {
    private String message;
    private Integer code;

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public CustomizeException(Integer code, String message) {
        this.message = message;
    }
}
