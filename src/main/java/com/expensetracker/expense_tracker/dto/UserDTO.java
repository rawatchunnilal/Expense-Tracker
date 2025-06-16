package com.expensetracker.expense_tracker.dto;

import lombok.Data;

@Data
public class UserDTO {

	public UserDTO() {
		System.out.println("UserDTO initialised");
	}

	private String username;
	private String password;
}
