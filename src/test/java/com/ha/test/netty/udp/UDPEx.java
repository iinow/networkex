package com.ha.test.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.oio.OioDatagramChannel;
import org.junit.Test;

import java.net.InetSocketAddress;

public class UDPEx {

    @Test
    public void start() throws InterruptedException {
        OioEventLoopGroup group = new OioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(OioDatagramChannel.class)
                .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                    @Override
                    protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket msg) throws Exception {
                        System.out.println(msg.toString());
                    }
                });

        ChannelFuture future = bootstrap.bind(new InetSocketAddress(2224));        //비연결 프로토콜을 이용
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                if(future.isSuccess()){
                    System.out.println("Channel bound");
                }else{
                    System.err.println("Bind attempt failed");
                    future.cause().printStackTrace();
                }
            }
        });

        group.shutdownGracefully().sync().syncUninterruptibly();
        Thread.sleep(10000);
    }
}
