package com.ha.test.netty.example;

import io.netty.buffer.*;
import io.netty.channel.ChannelHandler;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;
import org.junit.Test;

public class CompositeByteBufEx {
    @Test
    public void ex(){
        CompositeByteBuf msgBuf = Unpooled.compositeBuffer();
        ByteBuf headerbuf = new EmptyByteBuf(ByteBufAllocator.DEFAULT);
        msgBuf.addComponents(headerbuf);
//        ByteBufAllocator.DEFAULT.heap

        //메모리 해제하기
        ReferenceCountUtil.release("");

        SimpleChannelInboundHandler df;
        df.write();
        ChannelHandler
    }
}
