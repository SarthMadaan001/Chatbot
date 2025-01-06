package com.controller;

import com.service.ChatbotService;
import com.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/admin/analytics")
public class AnalyticsServlet extends HttpServlet {

    private ChatbotService chatbotService;

    @Override
    public void init() throws ServletException {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        chatbotService = new ChatbotService(databaseUtil);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ResultSet analytics = chatbotService.getAnalytics();
            // Convert ResultSet to JSON or other format and send as response
            response.getWriter().write("Analytics data fetched successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error fetching analytics: " + e.getMessage());
        }
    }
}