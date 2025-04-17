package com.example.chatty.controller;

import com.example.chatty.model.ChatMessage;
import com.example.chatty.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody ChatMessage message) {
        chatService.sendMessage(message);
    }

    @GetMapping("/messages/{recipient}")
    public List<ChatMessage> getMessages(@PathVariable("recipient") String recipient) {
        return chatService.getMessagesFor(recipient);
    }

    @GetMapping("/users")
    public Set<String> getAllRecipients() {
        return chatService.getAllRecipients();
    }
}
