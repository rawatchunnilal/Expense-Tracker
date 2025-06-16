package com.expensetracker.expense_tracker.repository;

import com.expensetracker.expense_tracker.model.User;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // custom query method
}
