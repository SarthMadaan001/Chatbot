package com.example;

import com.service.ChatbotService;
import com.util.DatabaseUtil;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Initialize DatabaseUtil
            DatabaseUtil databaseUtil = new DatabaseUtil();

            // Initialize ChatbotService with DatabaseUtil
            ChatbotService chatbotService = new ChatbotService(databaseUtil);

            // Add a new user
            chatbotService.addUser ("john_doe", "john@example.com");

            // Add a conversation for the user (assuming user_id = 1)
            chatbotService.addConversation(1, "Hello, chatbot!", "Hi, how can I help you?");
            chatbotService.addConversation(1, "What's the weather today?", "It's sunny and 25°C.");

            // Print conversation history for the user (user_id = 1)
            System.out.println("Fetching conversation history...");
            chatbotService.printConversationHistory(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}