package com.charcha.dto;

public class UserDTO {
    private String id;
    private String username;
    private String region;

    // Constructors
    public UserDTO() {}

    public UserDTO(String id, String username, String region) {
        this.id = id;
        this.username = username;
        this.region = region;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}
