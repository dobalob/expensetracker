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
src\resources\application.properties

### 5. Test Connection 
- mvn spring-boot:run
- localhost:8080
  - (Whitelabel Error Page)

### A. Create Git Project 
- git init .  

.gitignore
- git add .
- git status 
- git commit -m "Spring App connects to MySQL DB"
- git log --author="
Oisin"

### B. Push Project To GitHub 