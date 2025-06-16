package com.expensetracker.expense_tracker.controller;

import com.expensetracker.expense_tracker.dto.LoginResponse;
import com.expensetracker.expense_tracker.dto.UserDTO;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	UserController(){
		System.out.println("User Controller started");
	}

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        return userService.register(user);
    }
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody UserDTO userDTO) {
        return userService.login(userDTO);
    }

}
