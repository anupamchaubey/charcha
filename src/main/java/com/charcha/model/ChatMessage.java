package com.charcha.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatMessage {

    @Id
    private String id;

    private String senderName;         // Random anonymous name like "HappyLion1234"
    private String region;             // Region-based group
    private String content;            // Chat content
    private LocalDateTime timestamp;   // Timestamp of message
}
