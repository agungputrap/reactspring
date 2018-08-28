package com.agung.agungtesting.eventbus.event;

import java.util.Date;

public class TokenExpiredEvent {
    private String username;
    private Date expiredTime;

    public TokenExpiredEvent(String username, Date expiredTime) {
        this.username = username;
        this.expiredTime = expiredTime;
    }

    public String getUsername() {
        return username;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }
}
