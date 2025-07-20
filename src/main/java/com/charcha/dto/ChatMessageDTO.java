package com.charcha.dto;

public class ChatMessageDTO {
    private String content;
    private String region;

    // Constructors
    public ChatMessageDTO() {}

    public ChatMessageDTO(String content, String region) {
        this.content = content;
        this.region = region;
    }

    // Getters and Setters
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}
