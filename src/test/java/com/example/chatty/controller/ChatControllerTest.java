package com.example.chatty.controller;

import com.example.chatty.model.ChatMessage;
import com.example.chatty.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@WebMvcTest(controllers = ChatController.class)
public class ChatControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ChatService chatService;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testSendMessage() throws Exception {
        ChatMessage message = new ChatMessage("Alice", "Bob", "Ahoj");

        mockMvc.perform(post("/api/chat/message")
                        .contentType(APPLICATION_JSON)
                        .content(mapper.writeValueAsString(message)))
                .andExpect(status().isOk());
    }

    @Test
    void testGetMessagesForRecipient() throws Exception {
        ChatMessage message = new ChatMessage("Alice", "Bob", "Ahoj");

        Mockito.when(chatService.getMessagesFor("Bob"))
                .thenReturn(List.of(message));

        mockMvc.perform(get("/api/chat/messages/Bob"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sender").value("Alice"))
                .andExpect(jsonPath("$[0].content").value("Ahoj"));
    }

    @Test
    void testGetAllRecipients() throws Exception {
        Mockito.when(chatService.getAllRecipients())
                .thenReturn(Set.of("Bob", "Eva"));

        mockMvc.perform(get("/api/chat/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}
