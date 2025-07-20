package com.charcha.repository;

import com.charcha.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public class MessageRepository extends MongoRepository<Message, String> {



}