package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.junit.Test;

/**
 * 이 Sticky 기능은 안드로이드 뷰가 새로 생성될 때 이전에 전송된 이벤트를 받을 때 사용한다. default 값은 false 이다
 * */
public class EventBusStickyEx {
    @Test
    public void start(){
        EventBus.getDefault().postSticky(new MessageEvent("Hello everyone!"));
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){
        System.out.println(event.toString());
    }

    @Test
    public void removeSticky(){
        MessageEvent stickyEvent = EventBus.getDefault().getStickyEvent(MessageEvent.class);
        if(stickyEvent != null){
            EventBus.getDefault().removeStickyEvent(stickyEvent);
        }

        //remove 할때 꺼내온다 queue 에서 poll 같이
        MessageEvent stickyEvent2 = EventBus.getDefault().removeStickyEvent(MessageEvent.class);
        if(stickyEvent2 == null){

        }
    }
}
