package com.v1.expenses.expense;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
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
    
    @PostMapping("/expenses")
    public ResponseEntity<Expense> save( @RequestBody Expense expense)
    {
        Expense newExpense = expenseService.save( expense);
        return new ResponseEntity<Expense>( newExpense, HttpStatus.OK);
    }
    
    @GetMapping("/expenses/{id}")
    public ResponseEntity<Expense> get( @PathVariable("id") Long id)
    {
        Expense foundExpense = expenseService.findById( id);
        return new ResponseEntity<Expense>( foundExpense, HttpStatus.OK);
    }
    
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> delete( @PathVariable("id") Long id)
    {
        expenseService.delete( id);
        return new ResponseEntity<String>( "Expense delete successfully.", HttpStatus.OK);
    }
}
