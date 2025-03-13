# Company Management with Hibernate and MySQL  

## 📌 Description  
This project demonstrates basic company management using **Hibernate** with **MySQL**. It provides functionalities to add, search, update, and delete companies using **Hibernate ORM** and **HQL**.  

## 🚀 Features  
- **Add a company**: Insert a new company and display its generated ID.  
- **Find a company**: Retrieve a company by its ID.  
- **HQL Queries**:  
  - Retrieve all companies.  
  - Search for a company by name.  
  - Sort companies by the number of employees.  
  - Count the total number of companies.  
- **Update or delete a company**: Modify the name or remove a company using its ID.  

## 🛠️ Installation  
1. **Create the database**:  
   - Set up a MySQL database named `hibernate_db`.  
   - Create a table named `entreprises`.  

2. **Configure Hibernate**:  
   - Update `hibernate.cfg.xml` with your MySQL credentials (`username` and `password`).  

3. **Run the project**:  
   ```bash
   mvn clean install
   mvn exec:java -Dexec.mainClass="com.example.Main"
