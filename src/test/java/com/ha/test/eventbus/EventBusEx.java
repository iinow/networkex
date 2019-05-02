package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventBusEx {
    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    @Test
    public void start1() throws Exception {
//        EventBus bus = Factory.newEventBus();
        EventBus bus = EventBus.builder()
                .executorService(executorService)
                .logNoSubscriberMessages(true)
                .sendNoSubscriberEvent(true)
                .installDefaultEventBus();

        List<RestGo> list = new ArrayList<>();

        for(int i = 0; i < 1000; i++){
            RestGo go = new RestGo(bus);
            list.add(go);
        }
        bus.register(this);
        bus.post("start");
        System.out.println("시작!!");
        list.forEach(go->{
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e){
//
//            }
            executorService.submit(go);
        });
//        list.stream().forEach(go->go.start());
        System.out.println("끝!!");

//        list.parallelStream().forEach(go->executorService.submit(bus.post("start");));

        Thread.sleep(100000000);
    }

    private int cnt = 0;
    private long stime = 0;
    List<Long> period = new ArrayList<>();

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receive(String line){
//        try {
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
        if(line.equals("start")){
            stime = System.currentTimeMillis();
            return;
        }
        cnt++;

        long etime = System.currentTimeMillis();
        long p = (etime - stime);
        period.add(p);
        long sum = period.stream().mapToLong(i -> i).sum();
        System.out.println("걸린시간 : "+p+", 총 걸린시간: "+sum+", cnt: "+cnt);

        stime = etime;
    }

    private int cnt1 = 0;
    private long stime1 = 0;
    List<Long> period1 = new ArrayList<>();
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void receive1(String line){
//        try {
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }
        if(line.equals("start")){
            stime1 = System.currentTimeMillis();
            return;
        }
        cnt1++;

        long etime = System.currentTimeMillis();
        long p = (etime - stime1);
        period.add(p);
        long sum = period1.stream().mapToLong(i -> i).sum();
        System.out.println("2 걸린시간 : "+p+", 총 걸린시간: "+sum+", cnt: "+cnt1);

        stime1 = etime;
    }

    @Test
    public void ddd() throws Exception {
        new RestGo().start();
        Thread.sleep(100000000);
    }
}
