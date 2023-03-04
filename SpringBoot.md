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

## III, Create REST End-point 

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

