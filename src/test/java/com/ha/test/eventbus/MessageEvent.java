package com.ha.test.eventbus;

public class MessageEvent {
    private final String message;

    public MessageEvent(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "message : "+this.message;
    }
}
