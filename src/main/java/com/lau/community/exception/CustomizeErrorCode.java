package com.lau.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001,"该问题不存在或已删除"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中问题或评论进行回复"),
    USER_NOT_LOGIN(2003,"当前操作需要登录，请登录后刷新重试"),
    SYSTEM_ERROR(2004, "服务器炸了"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUNT(2006, "评论不存在"),
    CONTENT_IS_EMPTY(2007, "输入内容不能为空");

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
