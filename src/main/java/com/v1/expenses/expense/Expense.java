package com.v1.expenses.expense;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="tbl_expenses")
public class Expense 
{
    /* ******* */
    /* MEMBERS */
    /* ******* */
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY)
    private Long id;
    private String expense;
    private String descriptor; 
    private BigDecimal amount; 

    /* ******* */
    /* METHODS */
    /* ******* */
    public Long getId(){ return id; }
    public void setId( Long id){ this.id = id; }

    public String getExpense(){ return expense; }
    public void setExpense( String expense){ this.expense = expense; }
    
    public String getDescriptor(){ return descriptor; }
    public void setDescriptor( String descriptor){ this.descriptor = descriptor; }
    
    public BigDecimal getAmount(){ return amount; }
    public void setAmount( BigDecimal amount){ this.amount = amount; }
}
