package com.charcha.controller;

import com.charcha.model.ChatMessage;
import com.charcha.dto.MessageRequest;
import com.charcha.util.LocationUtil;
import com.charcha.util.RandomNameGenerator;
import com.charcha.repository.ChatMessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") // Limit this in production
public class ChatController {

    @Autowired
    private ChatMessageRepository messageRepository;

    @Autowired
    private LocationUtil locationUtil;

    @Autowired
    private RandomNameGenerator nameGenerator;

    @PostMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestBody MessageRequest request,
                                         HttpServletRequest servletRequest) {
        String ip = servletRequest.getRemoteAddr();
        String region = request.getRegion();
        if (region == null || region.isEmpty()) {
            region = locationUtil.getUserRegion(ip); // Fallback if user didn't enter manually
        }

        ChatMessage message = new ChatMessage();
        message.setSenderName(nameGenerator.generate()); // e.g., "User1234"
        message.setContent(request.getMessage());
        message.setRegion(region);
        message.setTimestamp(LocalDateTime.now());

        messageRepository.save(message);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<ChatMessage>> getMessages(@PathVariable String region) {
        List<ChatMessage> messages = messageRepository.findByRegionOrderByTimestampAsc(region);
        return ResponseEntity.ok(messages);
    }
}
