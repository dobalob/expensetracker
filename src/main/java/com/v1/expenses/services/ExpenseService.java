package com.v1.expenses.services;

import java.util.List;

import com.v1.expenses.entities.Expense;

public interface ExpenseService 
{
    /* ******* */
    /* METHODS */
    /* ******* */
    List<Expense> findAll();
}
