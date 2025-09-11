**Campus Equipment Loan System**

A Spring Boot REST API system for managing campus equipment loans for students.
 ** 🎯 Project Overview**
This system allows students to borrow campus equipment with automatic tracking of loan periods, availability, and penalties for overdue returns.


 **Domain Model**
 
Entities

**Equipment**
  • id - Unique identifier

  • name - Equipment name

  • type - Equipment category

  • serialNumber - Unique serial number

  • availability - Current availability status


**Student**

  • id - Unique identifier

  • studentNo - Student number

  • name - Student full name

  • email - Contact email


**Loan**

  • id - Unique identifier

  • equipment - Reference to borrowed equipment

  • student - Reference to borrowing student

  • startDate - Loan start date

  • dueDate - Expected return date

  • returnDate - Actual return date (nullable)

  • status - Current loan status


**📋 Business Rules**

  1. Loan Limit: Maximum 2 ACTIVE loans per student

  2. Loan Duration: 7 days standard loan period

  3. Overdue Policy: Loans are overdue if past due date

  4. Penalty System: ₱50/day late penalty (implemented using Strategy Pattern)

**🛠️ Technology Stack**

  • Java SDK 19
  
  • Spring Boot (Web, JPA, Validation)
  
  • H2 Database (In-memory)
  
**📄 License**

This project is for educational purposes as part of coursework.

**👨‍💻 Author**

Leo Jake de los Cientos

GitHub: @Sett373

Package: edu.cit.deloscientos.leojake.campusequipmentloan


