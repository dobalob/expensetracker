package com.v1.expenses.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.v1.expenses.entities.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long>{}
