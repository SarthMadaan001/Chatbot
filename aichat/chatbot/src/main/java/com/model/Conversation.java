package com.model;

public class Conversation {
    private int userId;
    private String message;
    private String response;

    // Constructor
    public Conversation(int userId, String message, String response) {
        this.userId = userId;
        this.message = message;
        this.response = response;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }

    public String getResponse() {
        return response;
    }

    // Setters (optional, if needed)
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}