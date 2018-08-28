package com.agung.agungtesting.eventbus.subscriber;

import com.agung.agungtesting.eventbus.event.TokenExpiredEvent;
import com.agung.agungtesting.eventbus.event.UserLoginEvent;
import com.agung.agungtesting.eventbus.event.UserLogoutEvent;
import com.agung.agungtesting.util.EmailUtil;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthEventSubscriber {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EmailUtil emailUtil;

    @Subscribe
    public void processing(UserLoginEvent userLoginEvent) {
        log.info(">>> process user login");
    }

    @Subscribe
    public void processing(UserLogoutEvent userLogoutEvent) {
        log.info(">>> process user logout");
    }

    @Subscribe
    public void processing(TokenExpiredEvent tokenExpiredEvent) {
        log.info(">>> process token expired");
    }
}
