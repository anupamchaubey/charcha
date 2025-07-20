
package com.charcha.service;

import com.charcha.model.User;

public interface UserService {
    User registerUser(User user);
    User findByUsername(String username);
    String detectRegionByIP(String ipAddress); // Stub for future
}
