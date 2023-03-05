package com.v1.expenses.expense;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService 
{
    /* ******* */
    /* MEMBERS */
    /* ******* */
    @Autowired
    ExpenseRepo dao;

    /* ******* */
    /* METHODS */
    /* ******* */
    @Override
    public List<Expense> findAll()
    { 
        return dao.findAll(); 
    }
    
    @Override
    public Expense save( Expense expense) 
    { 
        dao.save( expense);
        return expense; 
    }
}
