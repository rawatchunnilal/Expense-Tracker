package com.expensetracker.expense_tracker.service;

import com.expensetracker.expense_tracker.dto.LoginResponse;
import com.expensetracker.expense_tracker.dto.UserDTO;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	UserService() {
		System.out.println("User service initialised");
	}

	@Autowired
	private UserRepository userRepository;

	public String register(User user2) {
		if (userRepository.findByUsername(user2.getUsername()) != null) {
			return "Username already exists!";
		}

		User user = User.builder().username(user2.getUsername()).password(user2.getPassword()) 
				.build();

		userRepository.save(user);
		return "User registered successfully!";
	}

	public LoginResponse login(UserDTO userDTO) {
	    User user = userRepository.findByUsername(userDTO.getUsername());

	    if (user == null || !user.getPassword().equals(userDTO.getPassword())) {
	        return new LoginResponse("Invalid username or password!", null);
	    }

	    return new LoginResponse("Login successful!", user.getId());
	}
}
