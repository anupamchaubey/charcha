package com.charcha.repository;

import com.charcha.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    // Get messages for a region ordered by timestamp
    List<ChatMessage> findByRegionOrderByTimestampAsc(String region);
}
