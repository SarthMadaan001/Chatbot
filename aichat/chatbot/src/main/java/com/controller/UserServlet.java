package com.controller;

import com.service.ChatbotService;
import com.model.Conversation;
import com.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private ChatbotService chatbotService;

    @Override
    public void init() throws ServletException {
        // Initialize DatabaseUtil and ChatbotService
        DatabaseUtil databaseUtil = new DatabaseUtil();
        chatbotService = new ChatbotService(databaseUtil);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        try {
            // Add a new user
            chatbotService.addUser (username, email);
            response.getWriter().write("User  added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error adding user: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));

        try {
            // Print conversation history for the user
            chatbotService.printConversationHistory(userId);
            response.getWriter().write("Conversation history printed to console.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error fetching conversation history: " + e.getMessage());
        }
    }
}