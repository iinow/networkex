package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.util.AsyncExecutor;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * AsyncExecutor.create().execute() 에서 RunnableEx 가 있는데 throw Exception 을 던질 수가 있다.
 * */
public class EventBusAsyncEx {

    @Test
    public void start() throws Exception{
        EventBus.getDefault().register(this);

        AsyncExecutor.create().execute(()->{
            System.out.println("execute!!!");
            EventBus.getDefault().postSticky(new MessageEvent("AsyncExecutor 실행한다."));
            EventBus.getDefault().postSticky(new String("AsyncExecutor 실행한다.".getBytes(StandardCharsets.UTF_8)));
        });

        Thread.sleep(10000);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub1(MessageEvent event){
        System.out.println(event.toString());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub2(String str){
        System.out.println(str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sub3(Object str){
        System.out.println("object : "+str);
    }
}
