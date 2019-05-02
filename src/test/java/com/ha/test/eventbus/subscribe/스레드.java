package com.ha.test.eventbus.subscribe;

import io.netty.util.concurrent.ExecutorServiceFactory;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.*;

public class 스레드 {
    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Test
    public void start() throws Exception {
        executorService.scheduleWithFixedDelay(()-> System.out.println("실행: "+new Date()), 1, 3, TimeUnit.SECONDS);

        Thread.sleep(100000);
       /* TEST tt = new TEST();
        tt.start();
        tt.ee = true;
        tt.interrupt = true;*/
    }

    class D implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    class TEST extends Thread {

        private boolean ee = false;
        private boolean interrupt = false;

        @Override
        public void run() {
            while(!interrupt){
                if(ee){
                    System.out.println(ee);
                }
            }
        }
    }
}
