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

    private String senderAnonymousId; // Who sent it
    private String region;            // Which region's chatroom
    private String content;           // Message text
    private LocalDateTime timestamp;
}
