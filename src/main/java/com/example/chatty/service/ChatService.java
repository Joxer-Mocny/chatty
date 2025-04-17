package com.example.chatty.service;

import com.example.chatty.model.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatService {
    private final Map<String, List<ChatMessage>> messages = new HashMap<>();

    public void sendMessage(ChatMessage message) {
        messages.computeIfAbsent(message.getRecipient(), k -> new ArrayList<>()).add(message);
    }

    public List<ChatMessage> getMessagesFor(String recipient) {
        return messages.getOrDefault(recipient, Collections.emptyList());
    }

    public Set<String> getAllRecipients() {
        return messages.keySet();
    }
}
