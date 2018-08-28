package com.agung.agungtesting.eventbus.subscriber;

import com.agung.agungtesting.eventbus.event.SendEmailEvent;
import com.agung.agungtesting.util.EmailUtil;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EmailEventSubscriber {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Environment env;
    @Autowired
    EmailUtil emailUtil;

    @Subscribe
    public void processingSendEmailEvent(SendEmailEvent sendEmailEvent) {
        log.debug("send email event triggered");
        emailUtil.send(sendEmailEvent.getEmailDest(), sendEmailEvent.getSubject(),
                sendEmailEvent.getContent(), sendEmailEvent.getFileAttachment());
    }
}
