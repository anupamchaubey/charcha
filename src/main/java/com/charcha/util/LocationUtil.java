package com.charcha.util;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class LocationUtil {

    private final RestTemplate restTemplate = new RestTemplate();

    public String getUserRegion(String ip) {
        String url = "http://ip-api.com/json/" + ip;
        try {
            Map<String, String> response = restTemplate.getForObject(url, Map.class);
            return response != null ? response.get("regionName") : "Unknown";
        } catch (Exception e) {
            return "Unknown";
        }
    }
}
