package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Factory {
    private static ExecutorService executorService = Executors.newFixedThreadPool(3);

    public static EventBus newEventBus(){
        return EventBus.builder()
                .executorService(executorService)
                .logNoSubscriberMessages(true)
                .sendNoSubscriberEvent(true)
                .installDefaultEventBus();
    }
}
