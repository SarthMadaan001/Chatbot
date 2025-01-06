package com.service;

import com.dao.ChatbotDAO;
import com.model.User;
import com.model.Conversation;
import com.model.Configuration;
import com.util.DatabaseUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ChatbotServiceTest {

    @Mock
    private ChatbotDAO mockChatbotDAO;

    @Mock
    private DatabaseUtil mockDatabaseUtil;

    @InjectMocks
    private ChatbotService chatbotService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        chatbotService = new ChatbotService(mockDatabaseUtil);
    }

    @Test
    void testAddUser  () throws SQLException {
        // Arrange
        String username = "testUser  ";
        String email = "test@example.com";
        User user = new User(username, email);

        // Act
        chatbotService.addUser  (username, email);

        // Assert
        verify(mockChatbotDAO, times(1)).addUser  (user);
    }

    @Test
    void testAddConversation() throws SQLException {
        // Arrange
        int userId = 1;
        String message = "Hello, chatbot!";
        String response = "Hi, how can I help you?";
        Conversation conversation = new Conversation(userId, message, response);

        // Act
        chatbotService.addConversation(userId, message, response);

        // Assert
        verify(mockChatbotDAO, times(1)).addConversation(conversation);
    }

    @Test
    void testGetConversationHistory() throws SQLException {
        // Arrange
        int userId = 1;
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockChatbotDAO.getConversationHistory(userId)).thenReturn(mockResultSet);

        // Act
        ResultSet resultSet = chatbotService.getConversationHistory(userId);

        // Assert
        assertNotNull(resultSet);
        verify(mockChatbotDAO, times(1)).getConversationHistory(userId);
    }

    @Test
    void testPrintConversationHistory() throws SQLException {
        // Arrange
        int userId = 1;
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockResultSet.next()).thenReturn(true, false); // Simulate one row in the result set
        when(mockResultSet.getString("message")).thenReturn("Hello, chatbot!");
        when(mockResultSet.getString("response")).thenReturn("Hi, how can I help you?");
        when(mockResultSet.getTimestamp("timestamp")).thenReturn(null);
        when(mockChatbotDAO.getConversationHistory(userId)).thenReturn(mockResultSet);

        // Act
        chatbotService.printConversationHistory(userId);

        // Assert
        verify(mockChatbotDAO, times(1)).getConversationHistory(userId);
        verify(mockResultSet, times(1)).next();
        verify(mockResultSet, times(1)).getString("message");
        verify(mockResultSet, times(1)).getString("response");
        verify(mockResultSet, times(1)).getTimestamp("timestamp");
    }

    @Test
    void testUpdateConfiguration() throws SQLException {
        // Arrange
        String responseTemplate = "New Response Template";
        String knowledgeBase = "New Knowledge Base";

        // Act
        chatbotService.updateConfiguration(responseTemplate, knowledgeBase);

        // Assert
        verify(mockChatbotDAO, times(1)).updateConfiguration(responseTemplate, knowledgeBase);
    }
}