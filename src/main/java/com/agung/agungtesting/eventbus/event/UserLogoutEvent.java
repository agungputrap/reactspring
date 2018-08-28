package com.agung.agungtesting.eventbus.event;

import java.util.Date;

public class UserLogoutEvent {
    private String username;
    private Date logoutTime;
    private Date expiredTime;

    public UserLogoutEvent(String username, Date logoutTime, Date expiredTime) {
        this.username = username;
        this.logoutTime = logoutTime;
        this.expiredTime = expiredTime;
    }

    public String getUsername() {
        return username;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }
}
