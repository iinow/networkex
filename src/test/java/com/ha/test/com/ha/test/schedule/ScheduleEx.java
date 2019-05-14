package com.ha.test.com.ha.test.schedule;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;
import org.junit.Test;

import java.util.concurrent.*;

public class ScheduleEx {
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);

    @Test
    public void start() throws InterruptedException, ExecutionException {
        ScheduledFuture<?> future = executorService.schedule(()-> System.out.println("60초 경과.."), 60, TimeUnit.SECONDS);
        future.get();
        Thread.sleep(61000);
        executorService.shutdown();
    }

    @Test
    public void channel(){
        AttributeKey<Integer> id = AttributeKey.newInstance("ID");

        Channel ch = new NioSocketChannel();
        ch.eventLoop().schedule((Runnable) null, 22, null);

        ServerBootstrap b = new ServerBootstrap();
        b.bind();
        b.attr(id, 22);


        System.out.println(id.id());
        System.out.println(id.name());
        System.out.println(id.id());
    }
}
