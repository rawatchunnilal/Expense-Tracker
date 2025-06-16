package com.expensetracker.expense_tracker.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.expensetracker.expense_tracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	List<Expense> findByUserId(Long userId);
}