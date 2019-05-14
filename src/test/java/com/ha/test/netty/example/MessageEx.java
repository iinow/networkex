package com.ha.test.netty.example;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.TooLongFrameException;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class MessageEx {

    @Test
    public void testFramesDecoded(){
        ByteBuf buf = Unpooled.buffer();
        for(int i = 0; i < 9; i++){
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(3));

        assertTrue(channel.writeInbound(input.retain()));
        assertTrue(channel.finish());

        ByteBuf read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        System.out.println(read.readByte());
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        System.out.println(read.readByte());
        read.release();

        read = (ByteBuf) channel.readInbound();
        assertEquals(buf.readSlice(3), read);
        byte[] res = new byte[3];
        System.out.println(read.readBytes(res));
        for(byte bb : res){
            System.out.println(bb);
        }
        read.release();

        assertNull(channel.readInbound());
        buf.release();
    }

    @Test
    public void testFramesDecoded2(){
        ByteBuf buf = Unpooled.buffer();
        for(int i = 0; i < 9; i++){
            buf.writeByte(i);
        }

        ByteBuf input = buf.duplicate();

        EmbeddedChannel channel = new EmbeddedChannel(new FixedLengthFrameDecoder(2));
        assertTrue(channel.writeInbound(input.readBytes(2)));
//        assertTrue(channel.writeInbound(input.readBytes(6)));
    }

    class FixedLengthFrameDecoder extends ByteToMessageDecoder {
        private final int frameLength;

        public FixedLengthFrameDecoder(int frameLength){
            this.frameLength = frameLength;
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            while(in.readableBytes() >= frameLength){
                ByteBuf buf = in.readBytes(frameLength);
                out.add(buf);
            }
        }
    }

    class FrameChunkDecoder extends ByteToMessageDecoder{
        private final int maxFrameSize;

        public FrameChunkDecoder(int maxFrameSize){
            this.maxFrameSize = maxFrameSize;
        }

        @Override
        protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            int readableBytes = in.readableBytes();
            if(readableBytes > maxFrameSize){
                in.clear();
                throw new TooLongFrameException();
            }

            ByteBuf buf = in.readBytes(readableBytes);
            out.add(buf);
        }
    }
}
