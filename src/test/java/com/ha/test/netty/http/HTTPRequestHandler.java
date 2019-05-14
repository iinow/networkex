package com.ha.test.netty.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

import java.io.File;
import java.net.URL;

public class HTTPRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String wsUri;
    private static final File INDEX;

    static {
        URL location = HTTPRequestHandler.class
                .getProtectionDomain()
                .getCodeSource().getLocation();
        try{
            String path = location.toURI() + "index.html";
            path = !path.contains("file:")?path:path.substring(5);
            INDEX = new File(path);
        }catch (Exception e){
            throw new IllegalStateException("Unable to locate index.html", e);
        }
    }

    public HTTPRequestHandler(String wsUri){
        this.wsUri = wsUri;
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
//        if(wsUri.equalsIgnoreCase(request.getClass())
    }
}
