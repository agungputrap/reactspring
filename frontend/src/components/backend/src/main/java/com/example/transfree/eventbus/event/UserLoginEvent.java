package com.agung.agungtesting.eventbus.event;

import java.util.Date;

public class UserLoginEvent {
    private String username;
    private Date loginTime;

    public UserLoginEvent(String username, Date loginTime) {
        this.username = username;
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public Date getLoginTime() {
        return loginTime;
    }
}
