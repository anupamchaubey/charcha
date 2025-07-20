package com.charcha.service.impl;

import com.charcha.model.ChatMessage;
import com.charcha.repository.ChatMessageRepository;
import com.charcha.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage saveMessage(ChatMessage message) {
        message.setTimestamp(System.currentTimeMillis());
        return chatMessageRepository.save(message);
    }

    @Override
    public List<ChatMessage> getMessagesByRegion(String region) {
        return chatMessageRepository.findByRegion(region);
    }
}
