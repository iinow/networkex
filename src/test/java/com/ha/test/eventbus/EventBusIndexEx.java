package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.junit.Test;

/**
 * 이 기능은 EventBus3 부터 새로 추가 되었음...
 * 안드로이드에서 권장됩...
 *
 * 구독자가 많아서 인덱스로 관리하여 빨리 받아보게게게
 * */
public class EventBusIndexEx {

    @Test
    public void start(){
        EventBus.builder().addIndex(new Index());
    }

    class Index implements SubscriberInfoIndex {

        @Override
        public SubscriberInfo getSubscriberInfo(Class<?> subscriberClass) {
            SubscriberInfo info = new SubscriberInfo() {
                @Override
                public Class<?> getSubscriberClass() {
                    return null;
                }

                @Override
                public SubscriberMethod[] getSubscriberMethods() {
                    return new SubscriberMethod[0];
                }

                @Override
                public SubscriberInfo getSuperSubscriberInfo() {
                    return null;
                }

                @Override
                public boolean shouldCheckSuperclass() {
                    return false;
                }
            };
            return info;
        }
    }
}
