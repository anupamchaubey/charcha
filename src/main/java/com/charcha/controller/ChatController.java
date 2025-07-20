package com.charcha.controller;

import com.charcha.model.ChatMessage;
import com.charcha.model.User;
import com.charcha.repository.ChatMessageRepository;
import com.charcha.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatMessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody String messageContent, Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow();

        ChatMessage message = new ChatMessage();
        message.setSenderName("Anonymous");
        message.setMessage(messageContent);
        message.setRegion(user.getRegion());
        message.setTimestamp(LocalDateTime.now());

        messageRepository.save(message);
        return ResponseEntity.ok("Message sent to region: " + user.getRegion());
    }

    @GetMapping("/messages")
    public ResponseEntity<List<ChatMessage>> getMessages(Principal principal) {
        User user = userRepository.findByUsername(principal.getName()).orElseThrow();
        List<ChatMessage> messages = messageRepository.findByRegionOrderByTimestampAsc(user.getRegion());
        return ResponseEntity.ok(messages);
    }
}
