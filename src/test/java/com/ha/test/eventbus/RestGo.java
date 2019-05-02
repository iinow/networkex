package com.ha.test.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class RestGo extends Thread{
    private final String URL = "https://reqres.in/api/users/1";
    private EventBus bus = null;

    public RestGo(EventBus bus){
        this.bus = bus;
    }

    public RestGo(){ }

    @Override
    public void run() {
        try {
            /*java.net.URL url = new URL(this.URL);
            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = reader.lines().collect(Collectors.joining());
            System.out.println(line);
//            if(bus != null)
            Thread.sleep(1000);*/
            System.out.println("rrr");
                bus.post("rrrrrr");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
