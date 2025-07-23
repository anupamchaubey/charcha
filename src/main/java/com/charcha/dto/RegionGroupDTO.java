package com.charcha.dto;

public class RegionGroupDTO {
    private String regionName;
    private int userCount;

    public RegionGroupDTO() {}

    public RegionGroupDTO(String regionName, int userCount) {
        this.regionName = regionName;
        this.userCount = userCount;
    }

    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }

    public int getUserCount() { return userCount; }
    public void setUserCount(int userCount) { this.userCount = userCount; }
}
