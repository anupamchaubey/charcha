package com.charcha.model;

import java.time.LocalDateTime;

public class Message {

    private String id;

    private String sender;

    private String message;

    private LocalDateTime timestamp;

    private String messageRegion;

    public Message(String id, String sender, String message, String messageRegion) {
        this.id = id;
        this.sender = sender;
        this.message = message;
        this.messageRegion = messageRegion;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getMessageRegion() {
        return messageRegion;
    }
    public void setMessageRegion(String messageRegion) {
        this.messageRegion = messageRegion;
    }

}
