package com.expensetracker.expense_tracker.dto;

public class LoginResponse {
    private String message;
    private Long userId;

    public LoginResponse(String message, Long userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public Long getUserId() {
        return userId;
    }
}
