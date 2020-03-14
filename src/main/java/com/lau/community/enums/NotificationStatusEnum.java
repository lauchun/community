package com.lau.community.enums;

public enum NotificationStatusEnum {
    UNREAD(0),
    READED(1);

    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status) {
        this.status = status;
    }
}
