package com.controller;

import com.service.ChatbotService;
import com.util.DatabaseUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/algorithm")
public class AlgorithmServlet extends HttpServlet {

    private ChatbotService chatbotService;

    @Override
    public void init() throws ServletException {
        DatabaseUtil databaseUtil = new DatabaseUtil();
        chatbotService = new ChatbotService(databaseUtil);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String feedback = request.getParameter("feedback");
        String performanceData = request.getParameter("performanceData");

        try {
 chatbotService.improveAlgorithm(feedback, performanceData);
            response.getWriter().write("Algorithm updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error updating algorithm: " + e.getMessage());
        }
    }
}