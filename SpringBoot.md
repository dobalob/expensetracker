# Angular and Spring Boot (B2 Tech)

## I, Project Setup 

### 1. Create Maven Project
pom.xml
- mvn clean package

### 2. Create MySQL Database 
sql\expensetracker.sql
- \c localhost@root
- \sql
- \source C:/.../sql/expensetracker.sql

### 3. Create Spring Boot App 
src\main\com\v1\expenses\ExpenseTrackerApp.java

### 4. Connect App To Database 
src\main\resources\application.properties

### 5. Test Connection 
- mvn spring-boot:run
- localhost:8080
  - (Whitelabel Error Page)

### 6. Create Git Project 
- git init .  

.gitignore
- git add .
- git status 
- git commit -m "Spring App connects to MySQL DB"
- git log --author="Oisin"

### 7. Create GitHub Repository
https://github.com/dobalob/expensetracker

### 8. Push To GitHub Repository 
- git remote add origin git@github.com:dobalob/expensetracker.git
- git remote 
- git checkout 
- git checkout -b main
- git push -u origin main

## II, Populate Database 

### 1. Create Git Branch 
- git checkout -b indev 
- git branch -a 
- git status 

### 2. Create Expense Entity 
src\main\java\com\v1\expenses\emtities\Expense.java

### 3. Generate Table From Entity 
src\main\resources\application.properties
- spring.jpa.generate-ddl=true  

- mvn spring-boot:run
  - Expense table generated in database

### 4. Push Branch To GitHub 
- git status 
- git add .
- git status 
- git commit -m "Generate table from entity"
- git push -u origin indev
- git branch -a 

### 5. Merge Branch With Main 
- git checkout main 
- git branch -a 
- git status 
- git merge indev 
- git status 
- git add .
- git commit -m "Generate table from entity"
- git push -u origin main
- git checkout indev 
- git branch -a 

## III, Create REST READ End-point 

## 1. Populate Database Table 
sql\expenses.sql

## 2. Create Expense Repository 
src\main\java\com\v1\expenses\repos\ExpenseRepo.java

## 3. Create Expense Service 
src\main\java\com\v1\expenses\services\ExpenseService.java

## 4. Implement Expense Service
src\main\java\com\v1\expenses\services\ExpenseServiceImpl.java

## 5. Create Expense Controller 
src\main\java\com\v1\expenses\controllers\ExpenseController.java

## IV, Create Angular Project

### 1. Generate Angular App 
- ng new ng

### 2. Run Angular App 
ng\
- ng serve 
- localhost:4200

### 3. Create Expense Model Class  
ng\ 
- ng g class models/expense --skip-tests
ng\src\app\models\expense.ts
```TS
export class Expense {
    id: number = 0;
    expense: string[] = [];
    amount: number = 0;
    description: string[] = [];
}
```

### 4. Add Expense Routing Service 
ng\ 
- ng g s services/expense --skip-tests
ng\src\app\services\expense.service.ts

### 5. Create Expense Component 
ng\
- ng g c components/listExpenses --skip-tests  

ng\src\app\components\list-expenses.service.ts

### 6. Test Expense Component Selector 
ng\src\app\app.component.html

### 7. REST End-point GET Request 
#### 7.1 Import HttpClientModule 
ng\src\app\app.module.ts

#### 7.2 Add GET Request Service 
ng\src\app\services\expense.service.ts

#### 7.3 Call Service From Component
ng\src\app\components\list-expenses.component.ts
ng\src\app\components\list-expenses.component.html

#### 7.4 Allow Cross Origin Requests 
src\main\java\com\v1\expenses\ExpenseTrackerApp.java 

## V, Allow Table Entry Creation 

### 1. Create REST Create End-point
#### 1.1 Add Service Create Method
src\main\java\com\v1\expenses\expense\ExpenseService.java

#### 1.2 Implement Service Create Method
src\main\java\com\v1\expenses\expense\ExpenseServiceImpl.java

#### 1.3. Add Controller Create Method 
src\main\java\com\v1\expenses\expense\ExpenseController.java

### 2. Test Create Method 
- mvn spring-boot:run
Postman 
- Collections > New Collection > "Expense Tracker" 
- Expense Tracker > Add Request 
  - POST | http://localhost:8080/api/v1/expenses
    - Body > raw > JSON (application/json)
  - Send

### 3. REST End-point POST Request
#### 3.1 Add Angular App Routing 
ng\
- ng g c components/addExpense --skip-tests  

ng\src\app\app.component.ts
- Define routes 
```TS
const routers: Routes = [
  { path: 'expenses', component: ListExpensesComponent },
  { path: 'addexpense', component: AddExpenseComponent }, 
  { path: '', redirectTo: '/expenses', pathMatch: 'full' }
];
```
ng\src\app\app.component.html
- localhost:4200/expenses
- localhost:4200/addexpense

#### 3.2 Add POST Request Service 
ng\src\app\services\expense.service.ts
ng\src\app\components\add-expense.component.ts

#### 3.3 POST Request Angular Form
ng\src\app\app.module.ts
```TS
import { FormsModule } from "@angular/forms";
```
ng\src\app\components\add-expense.component.html
(Add Form)

ng\src\app\components\list-expenses.component.html
(Add Button (using routerLink, not href))

## VI, Get Single Table Entry
### 1. New REST Read End-point
#### 1.1 Add Service Read Method
src\main\java\com\v1\expenses\expense\ExpenseService.java

#### 1.2 Implement Service Read Method
src\main\java\com\v1\expenses\expense\ExpenseServiceImpl.java

#### 1.3. Add Controller Read Method 
src\main\java\com\v1\expenses\expense\ExpenseController.java 

### 2. Test Get Method
- mvn spring-boot:run
Postman 
- Expense Tracker > Add Request 
  - GET | http://localhost:8080/api/v1/expenses/1
  - Send

### 3. REST End-point GET Request
#### 3.1 Add Angular App Routing 
ng\src\app\app.module.ts

ng\src\app\components\add-expense.component.ts

#### 3.2 Add GET Request Service 
ng\src\app\services\expense.service.ts
ng\src\app\components\list-expenses.component.ts
ng\src\app\components\add-expense.component.ts

#### 3.3 GET Request Angular Form
ng\src\app\app.module.ts
```TS
import { FormsModule } from "@angular/forms";
```
ng\src\app\components\add-expense.component.html  
(Add Form)

ng\src\app\components\list-expenses.component.html  
(Add Button (using routerLink, not href))

## VII, Get Delete Table Entry
### 1. New REST Delete End-point
#### 1.1 Add Service Delete Method
src\main\java\com\v1\expenses\expense\ExpenseService.java

#### 1.2 Implement Service Delete Method
src\main\java\com\v1\expenses\expense\ExpenseServiceImpl.java

#### 1.3. Add Controller Delete Method 
src\main\java\com\v1\expenses\expense\ExpenseController.java 

### 2. Test Delete Method
- mvn spring-boot:run
Postman 
- Expense Tracker > Add Request 
  - DELETE | http://localhost:8080/api/v1/expenses/3
  - Send

### 3. REST End-point GET Request
#### 3.1 Add DELETE Request Service 
ng\src\app\services\expense.service.ts
ng\src\app\components\add-expense.component.ts

#### 3.2 DELETE Request On Edit Page
ng\src\app\components\add-expense.component.html

#### 3.3 DELETE Request On List Page
ng\src\app\components\list-expenses.component.ts
ng\src\app\components\list-expenses.component.html

## VIII, Filter Records By Name 
### 1. Create Filter Container Object
ng\src\app\components\list-expenses.component.ts

### 2. Create Filter Method
ng\src\app\components\list-expenses.component.ts

### 3. Create Filter Search Box
ng\src\app\components\list-expenses.component.html

### 4. Test Filter Box
F12 > Console  
(Filter Box) > "b"

### 5. Call Filter From List 
ng\src\app\components\list-expenses.component.html

### 4. Test List Filter 
(Filter Box) > <string>