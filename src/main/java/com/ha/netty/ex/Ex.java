package com.ha.netty.ex;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class Ex {
    public static void main(String[] args) {
        SimpleChannelInboundHandler<String> channelInboundHandler = new SimpleChannelInboundHandler<String>() {
            @Override
            protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {

            }
        };

        ChannelHandlerAdapter adapter = new ChannelHandlerAdapter();
    }
}
