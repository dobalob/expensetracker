import { Component, OnInit } from '@angular/core';
import { Expense } from 'src/app/models/expense';
import { ExpenseService } from 'src/app/services/expense.service';

@Component({
  selector: 'app-list-expenses',
  templateUrl: './list-expenses.component.html',
  styleUrls: ['./list-expenses.component.css']
})
export class ListExpensesComponent implements OnInit{

  /* ******* */
  /* MEMBERS */
  /* ******* */
  expenses: Expense[] = [];
  filters = {
    keyword: '',
    sortBy: 'Name'
  }

  /* ******* */
  /* METHODS */
  /* ******* */
  deleteExpense( id: number)
  {
    this._expenseService.deleteExpense( id).subscribe(
      data => {
        console.log('Delete response', data);
        this.listExpenses();
      }
    )
  }

  listExpenses() {
    this._expenseService.getExpenses().subscribe(
      data => this.expenses = this.filterExpenses( data)
    );
  }

  filterExpenses( expenses: Expense[]) 
  {
    return expenses.filter( ( e) => {
      return e.expense.toString().toLowerCase().includes( this.filters.keyword.toLowerCase());
    }).sort((a, b) => {
      if( this.filters.sortBy==='Name') 
      {
        return a.expense.toString().toLowerCase() < b.expense.toString().toLowerCase() ? -1 : 1;
      }
      else if( this.filters.sortBy==='Amount')
      {
        return a.amount < b.amount ? -1 : 1;
      }
      else 
      {
        console.log('Error sorting expenses')
        return 0;
      }
    })
  }

  /* ************ */
  /* CONSTRUCTORS */
  /* ************ */
  constructor( private _expenseService: ExpenseService ) { }

  ngOnInit(): void {
    this.listExpenses();
  }

}
