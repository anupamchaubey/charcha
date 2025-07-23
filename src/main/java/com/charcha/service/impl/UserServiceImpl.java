package com.charcha.service.impl;

import com.charcha.service.UserService;
import com.charcha.util.LocationUtil;
import com.charcha.util.RandomNameGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LocationUtil locationUtil;

    @Autowired
    private RandomNameGenerator randomNameGenerator;

    @Override
    public String detectRegionByIP(String ipAddress) {
        return locationUtil.getUserRegion(ipAddress);
    }

    public String generateRandomUsername() {
        return randomNameGenerator.generate();
    }
}
