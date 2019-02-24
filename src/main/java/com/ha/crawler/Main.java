package com.ha.crawler;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws Exception {/*
        System.out.println("Hello world");
        URI uri = new URI();
        URL url = new URL("https://github.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String temp = "";
        int rank = 0;

        while((temp = br.readLine()) != null){
            System.out.println(temp);
        }

        connection.disconnect();
        br.close();

        InetAddress address = new InetAddress();*/

//        openStream();
        getContent();
    }

    public static void openStream() throws Exception {
        URI uri = new URI("http://www.lolcats.com");
        URL u = uri.toURL();
        InputStream in = u.openStream();
        int c;
        while((c = in.read()) != -1) {
            System.out.write(c);
        }
        in.close();
    }

    public static void getContent() throws Exception {
        URI uri = new URI("http://www.lolcats.com");
        URL u = uri.toURL();
        System.out.println(u.getContent());
    }
}
