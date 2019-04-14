package com.ha.test.netty.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;

public class ChannelEx {
    @Test
    public void channel1() throws Exception {
        int port = 2929;
        Channel channel = new NioSocketChannel();
        channel.connect(new InetSocketAddress(port));

        ByteBuf buf = Unpooled.copiedBuffer("your data", CharsetUtil.UTF_8);
        ChannelFuture cf = channel.writeAndFlush(buf);
        cf.addListener((ChannelFutureListener) future -> {
            if(future.isSuccess()){
                System.out.println("Write Success");
            }else{
                System.err.println("Write Error");
                future.cause().printStackTrace();
            }
        });
        ByteBuffer header = ByteBuffer.allocate(22);
        ByteBuffer msg2 = ByteBuffer.allocate(header.remaining());
        msg2.put(header);
        msg2.flip();
    }
}
