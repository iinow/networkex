package com.ha.test.eventbus.subscribe;

import com.ha.test.eventbus.MessageEvent;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.junit.Test;

public class EventBusEx {
    @Test
    public void startBus(){
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new MessageEvent("Hello world"));
        System.out.println("됐나?");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event){
        System.out.println(event.toString());
    }

    //@Subscribe default threadMode = POSTING, 동기
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onMessageEvent_sync(MessageEvent event){
        System.out.println(event.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMessageEvent_order(MessageEvent event){
        System.out.println("order "+event.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
    public void onMessageEvent_order1(MessageEvent event){
        System.out.println("order1 "+event.toString());
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onMessageEvent_async(MessageEvent event){
        System.out.println("async "+event.toString());
    }
}
