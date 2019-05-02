package com.ha.test.eventbus;

import io.netty.util.concurrent.ExecutorServiceFactory;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBusBuildEx {
    //default 가 newCacheThreadPool 로 되어있어서 고정으로 바꿔 넣자
    private ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Test
    public void start() throws Exception{
        EventBus bus = EventBus.builder()
                .executorService(executorService)
                .logNoSubscriberMessages(true)
                .sendNoSubscriberEvent(true)
                .installDefaultEventBus();
//                .build(); 새로운 객체를 반환해줌 default 로 치환하지 않음

        bus.register(this);

        bus.post(new MessageEvent("Event Go!!"));
        Thread.sleep(10000);
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void message1(MessageEvent event){
        System.out.println("1 "+event.toString());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void message2(MessageEvent event){
        System.out.println("2 "+event.toString());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void message3(MessageEvent event){
        System.out.println("3 "+event.toString());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void message4(MessageEvent event){
        System.out.println("4 "+event.toString());
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
