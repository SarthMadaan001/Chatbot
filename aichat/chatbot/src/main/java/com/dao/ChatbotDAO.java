package com.dao;

import com.model.User;
import com.model.Conversation;
import com.util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatbotDAO {

    private final DatabaseUtil databaseUtil;

    // Constructor to accept DatabaseUtil dependency
    public ChatbotDAO(DatabaseUtil databaseUtil) {
        this.databaseUtil = databaseUtil;
    }

    // Add a new user
    public void addUser (User user) throws SQLException {
        String sql = "INSERT INTO User (username, email) VALUES (?, ?)";
        try (Connection conn = databaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.executeUpdate();
        }
    }

    // Add a new conversation
    public void addConversation(Conversation conversation) throws SQLException {
        String sql = "INSERT INTO Conversation (user_id, message, response) VALUES (?, ?, ?)";
        try (Connection conn = databaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, conversation.getUserId());
            pstmt.setString(2, conversation.getMessage());
            pstmt.setString(3, conversation.getResponse());
            pstmt.executeUpdate();
        }
    }

    // Retrieve conversation history for a user
    public ResultSet getConversationHistory(int userId) throws SQLException {
        String sql = "SELECT * FROM Conversation WHERE user_id = ?";
        Connection conn = databaseUtil.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, userId);
        return pstmt.executeQuery();
    }

    public void updateConfiguration(String responseTemplate, String knowledgeBase) throws SQLException {
        String sql = "UPDATE Configuration SET response_template = ?, knowledge_base = ? WHERE id = 1";
        try (Connection conn = databaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, responseTemplate);
            pstmt.setString(2, knowledgeBase);
            pstmt.executeUpdate();
        }
    }    
}