package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.Test;

/**
 * 우선순위가 높은 것이 제일 먼저 실행된다. 내림차순!!
 *
 * EventBus.getDefault().cancelEventDelivery(event);
 * 이 기능은 만약 우선순위 높은 곳에서 cancel 해버리면 아래 순위 애들은 전달받지 못함
 * */
public class EventBusPriorityEx {

    @Test
    public void start(){
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(new MessageEvent("이벤트 ㄱㄱ"));
    }

//    @Subscribe
    @Subscribe(priority = 1)
    public void event1(MessageEvent event){
        System.out.println("1 "+event.toString());
    }

//    @Subscribe
    @Subscribe(priority = 2)
    public void event2(MessageEvent event){
        System.out.println("2 "+event.toString());
        EventBus.getDefault().cancelEventDelivery(event);
    }

//    @Subscribe
    @Subscribe(priority = 3)
    public void event3(MessageEvent event){
        System.out.println("3 "+event.toString());
//        EventBus.getDefault().cancelEventDelivery(event);
    }

    @Subscribe
    public void event0(MessageEvent event){
        System.out.println("0 "+event.toString());
    }
}
