package com.v1.expenses.expense;

import java.util.List;

public interface ExpenseService 
{
    /* ******* */
    /* METHODS */
    /* ******* */
    List<Expense> findAll();

    Expense save( Expense expense);

    Expense findById( Long id);

    void delete( Long id);
}
