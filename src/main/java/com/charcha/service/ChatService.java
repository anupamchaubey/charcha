package com.charcha.service;

import com.charcha.model.ChatMessage;

import java.util.List;

public interface ChatService {
    ChatMessage saveMessage(ChatMessage message);
    List<ChatMessage> getMessagesByRegion(String region);
}
