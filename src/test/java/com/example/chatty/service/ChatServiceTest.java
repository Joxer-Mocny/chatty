package com.example.chatty.service;

import com.example.chatty.model.ChatMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChatServiceTest {

    private ChatService chatService;

    @BeforeEach
    void setUp() {
        chatService = new ChatService();
    }

    @Test
    void testSendAndReceiveMessage() {
        ChatMessage msg = new ChatMessage("Alice", "Bob", "Ahoj Bob!");
        chatService.sendMessage(msg);

        List<ChatMessage> messages = chatService.getMessagesFor("Bob");
        assertEquals(1, messages.size());
        assertEquals("Alice", messages.get(0).getSender());
        assertEquals("Ahoj Bob!", messages.get(0).getContent());
    }

    @Test
    void testEmptyMessagesListForUnknownUser() {
        List<ChatMessage> messages = chatService.getMessagesFor("Unknown");
        assertNotNull(messages);
        assertTrue(messages.isEmpty());
    }

    @Test
    void testMultipleMessages() {
        chatService.sendMessage(new ChatMessage("Alice", "Bob", "Prvá"));
        chatService.sendMessage(new ChatMessage("Charlie", "Bob", "Druhá"));
        chatService.sendMessage(new ChatMessage("Dana", "Eva", "Tretia"));

        List<ChatMessage> bobMessages = chatService.getMessagesFor("Bob");
        assertEquals(2, bobMessages.size());

        List<ChatMessage> evaMessages = chatService.getMessagesFor("Eva");
        assertEquals(1, evaMessages.size());
    }
}
