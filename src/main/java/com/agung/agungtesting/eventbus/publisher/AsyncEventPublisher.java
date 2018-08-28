package com.agung.agungtesting.eventbus.publisher;

import com.agung.agungtesting.eventbus.subscriber.AuthEventSubscriber;
import com.agung.agungtesting.eventbus.subscriber.EmailEventSubscriber;
import com.agung.agungtesting.util.DebugUtil;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;

@Component
public class AsyncEventPublisher {

    Logger log = LoggerFactory.getLogger(this.getClass());

    AsyncEventBus asyncEventBus;

    @Autowired
    EmailEventSubscriber emailEventSubscriber;
    @Autowired
    AuthEventSubscriber authEventSubscriber;

    @Autowired
    DebugUtil debugUtil;

    @PostConstruct
    private void init() {
        asyncEventBus = new AsyncEventBus(Executors.newCachedThreadPool(), new SubscriberExceptionHandler() {
            @Override
            public void handleException(Throwable throwable, SubscriberExceptionContext subscriberExceptionContext) {
                log.error("asyncEventBus : ", throwable);
            }
        });
        asyncEventBus.register(emailEventSubscriber);
        asyncEventBus.register(authEventSubscriber);
    }

    public void sendEvent(Object event) {
        asyncEventBus.post(event);
    }

}
