package com.charcha.service.impl;

import com.charcha.model.User;
import com.charcha.repository.UserRepository;
import com.charcha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        }
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public String detectRegionByIP(String ipAddress) {
        // Stubbed logic for region detection
        // In future: integrate with IP geolocation API
        return "DefaultRegion";
    }
}
