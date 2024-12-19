package com.example.proyectodsa_android.models;

public class QuestionPayload {
    private String date;
    private String title;
    private String message;
    private String sender;
    private String username;

    public QuestionPayload(String date, String title, String message, String sender, String username) {
        this.date = date;
        this.title = title;
        this.message = message;
        this.sender = sender;
        this.username = username;
    }

    // Getter and Setter methods
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
