package com.huy.homework2.model;

public class Message {
    private String content;

    //0:send; 1: receive
    private int type;

    public Message(String Message) {
        this.content = Message;
        this.type = 0;
    }

    public Message(String Message, int type) {
        this.content = Message;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String Message) {
        this.content = Message;
    }

}
