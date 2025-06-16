package com.expensetracker.expense_tracker.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {
	private String title;
	private Double amount;
	private LocalDate date;
	private String category;

	private Long userId;
}
