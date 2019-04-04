package com.ha.test.netty.echo;

import org.junit.Test;

public class App {

    @Test
    public void startServer() throws Exception {
        int port = 2020;
//        if (args.length != 1) {
//            System.out.println("Usage: " + EchoServer.class.getSimpleName() + " <port>");
//        }
//        port = Integer.parseInt(args[0]);
        new EchoServer(port).start();
    }

    @Test
    public void startClient() throws Exception {
//        if (args.length != 2) {
//            System.out.println("Usage: " + EchoClient.class.getSimpleName() + "<host> <port>");
//            return;
//        }

//        String host = args[0];
//        int port = Integer.parseInt(args[1]);
        String host = "localhost";
        int port = 2020;
        new EchoClient(host, port).start();
    }
}
