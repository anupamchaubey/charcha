package com.charcha.controller;

import com.charcha.model.Message;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
public class MessageController {

    @PostMapping("/sendMessage")
    public boolean send(@RequestBody Message message) {

    }

    @GetMapping("/allMessages")
    public List<Message> getAllMessages() {

    }

}