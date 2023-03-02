package com.v1.expenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.v1.expenses.entities.Expense;
import com.v1.expenses.services.ExpenseService;

@RestController
@RequestMapping("/api/v1")
public class ExpenseController 
{
    @Autowired
    ExpenseService expenseService;

    @GetMapping("/expenses")
    public ResponseEntity<List<Expense>> get()
    {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<List<Expense>>( expenses, HttpStatus.OK);
    }
}
