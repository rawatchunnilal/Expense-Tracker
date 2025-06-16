package com.expensetracker.expense_tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensetracker.expense_tracker.dto.ExpenseDTO;
import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin(origins = "*") // For frontend to access
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> addExpense(@RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(expenseService.saveExpense(dto));
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getExpenses(@RequestParam Long userId) {
        return ResponseEntity.ok(expenseService.getExpensesByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
    }
}
