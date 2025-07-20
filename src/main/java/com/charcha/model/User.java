package com.charcha.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private String id;

    private String username;     // Used for login
    private String password;     // Hashed password
    private String role;         // e.g., "CUSTOMER", "ADMIN"
    private String region;       // Auto-detected region
    private String anonymousId;  // Optional label like "User1234"
    private LocalDateTime joinedAt;
}
