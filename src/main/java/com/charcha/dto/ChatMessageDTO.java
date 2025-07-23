package com.charcha.dto;

import java.time.LocalDateTime;

public class ChatMessageDTO {
    private String content;
    private String region;
    private String senderName;
    private LocalDateTime timestamp;

    public ChatMessageDTO() {}

    public ChatMessageDTO(String content, String region, String senderName, LocalDateTime timestamp) {
        this.content = content;
        this.region = region;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getSenderName() { return senderName; }
    public void setSenderName(String senderName) { this.senderName = senderName; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
