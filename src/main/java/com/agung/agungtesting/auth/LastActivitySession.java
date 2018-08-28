package com.agung.agungtesting.auth;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;

@Component
public class LastActivitySession {

    Map<String, Date> map;

    @PostConstruct
    public void init(){
        map = Maps.newHashMap();
    }

    public boolean hasSession(String username) {
        return this.getLastActivity(username) != null;
    }

    public Date getLastActivity(String username) {
        return map.get(username);
    }

    public void put(String username, Date lastActivity) {
        map.put(username, lastActivity);
    }

    public void remove(String username) {
        map.remove(username);
    }
}
