package com.expensetracker.expense_tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.expense_tracker.dto.ExpenseDTO;
import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.model.User;
import com.expensetracker.expense_tracker.repository.ExpenseRepository;
import com.expensetracker.expense_tracker.repository.UserRepository;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense saveExpense(ExpenseDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                        .orElseThrow(() -> new RuntimeException("User not found"));

        Expense expense = new Expense();
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());
        expense.setCategory(dto.getCategory());

        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense expense = expenseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Expense not found"));

        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setDate(dto.getDate());

        return expenseRepository.save(expense);
    }
}
