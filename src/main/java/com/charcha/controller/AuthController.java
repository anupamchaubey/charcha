package com.charcha.controller;

import com.charcha.model.User;
import com.charcha.repository.UserRepository;
import com.charcha.security.JwtUtil;
import com.charcha.util.LocationUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LocationUtil locationUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Registers a new user.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("CUSTOMER");
        user.setRegion("Unknown"); // Will be updated during login
        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully.");
    }

    /**
     * Authenticates a user and returns a JWT token.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password,
                                   HttpServletRequest request) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception ex) {
            return ResponseEntity.status(401).body("Invalid username or password.");
        }

        // Get IP and resolve region
        String ip = request.getRemoteAddr();
        String region = locationUtil.getUserRegion(ip);

        // Update region in DB
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRegion(region);
            userRepository.save(user);
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(username);

        return ResponseEntity.ok().body("Bearer " + token);
    }
}
