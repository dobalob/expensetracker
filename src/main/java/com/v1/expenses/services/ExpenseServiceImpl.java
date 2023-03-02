package com.v1.expenses.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v1.expenses.entities.Expense;
import com.v1.expenses.repos.ExpenseRepo;

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
}
