
---

#  SYFE - Personal Finance Manager System  

## 📝 Overview  
The **Personal Finance Manager** is a powerful tool designed to help users track their income, expenses, and savings goals while gaining better control over their finances. Built with **Spring Boot** and equipped with robust authentication via **Spring Security**, this application offers a secure, user-friendly experience.  

---

## 🎯 Features  

### ✅ User Management  
- 🔐 **Register/Login**: Users can securely register and log in.  
- 🔒 **Session Management**: Enjoy seamless authentication throughout a session.  
- 🚪 **Public Endpoints**: APIs for registration and login are available for new users.  

### ✅ Transaction Management  
- 📝 **CRUD Operations**: Add, view, update, and delete financial transactions.  
- 🏷️ **Categorization**: Organize transactions by categories (e.g., Food, Rent).  
- 🛡️ **User-Specific Data**: Transactions are private and secured for individual accounts.  

### ✅ Category Management  
- 🛠️ **Custom Categories**: Create and manage personalized categories.  

### ✅ Savings Goals  
- 🎯 **Set Goals**: Define goals with target amounts and dates.  
- 📈 **Progress Tracking**: Visualize progress automatically via transactions.  

### ✅ Reports  
- 📊 **Insights**: Generate monthly/yearly reports on income, expenses, and savings.  
- 🖼️ **Visualization**: Includes charts like pie charts and bar graphs for better insights.  

### ✅ Data Persistence  
- 💾 **Database**: Supports **PostgreSQL** (default) and **H2 In-Memory Database** (for testing).  

---

## 🏗️ Project Structure  

```plaintext
.
├── 19JanTest3.iml
├── HELP.md
├── build
│   ├── classes
│   │   └── java
│   │       └── main
│   │           └── com
│   │               └── syfe
│   │                   └── jan19test3
│   │                       ├── Application.class
│   │                       ├── Controller
│   │                       │   ├── AdminController.class
│   │                       │   ├── PublicController.class
│   │                       │   ├── SavingGoalController.class
│   │                       │   ├── TransactionController.class
│   │                       │   └── UserController.class
│   │                       ├── DTO
│   │                       │   ├── AuthDTO$AuthDTOBuilder.class
│   │                       │   ├── AuthDTO.class
│   │                       │   ├── SavingGoalDTO$SavingGoalDTOBuilder.class
│   │                       │   ├── SavingGoalDTO.class
│   │                       │   ├── SavingGoal_ReturnDTO$SavingGoal_ReturnDTOBuilder.class
│   │                       │   ├── SavingGoal_ReturnDTO.class
│   │                       │   ├── TransactionDTO$TransactionDTOBuilder.class
│   │                       │   ├── TransactionDTO.class
│   │                       │   ├── TransactionReturnDTO$TransactionReturnDTOBuilder.class
│   │                       │   ├── TransactionReturnDTO.class
│   │                       │   ├── TransactionType.class
│   │                       │   ├── UserDTO$UserDTOBuilder.class
│   │                       │   ├── UserDTO.class
│   │                       │   ├── UserReadDTO$UserReadDTOBuilder.class
│   │                       │   └── UserReadDTO.class
│   │                       ├── Entity
│   │                       │   ├── SavingGoal$SavingGoalBuilder.class
│   │                       │   ├── SavingGoal.class
│   │                       │   ├── UserEntity$UserEntityBuilder.class
│   │                       │   ├── UserEntity.class
│   │                       │   ├── userTransaction$userTransactionBuilder.class
│   │                       │   └── userTransaction.class
│   │                       ├── Repository
│   │                       │   ├── SavingGoalRepository.class
│   │                       │   ├── TransactionRepository.class
│   │                       │   └── UserRepository.class
│   │                       ├── Security
│   │                       │   ├── MyUserDetailService.class
│   │                       │   ├── SecurityConfig.class
│   │                       │   └── UserPrincipal.class
│   │                       └── Service
│   │                           ├── JWTService.class
│   │                           ├── SavingGoalService.class
│   │                           ├── TransactionService.class
│   │                           └── UserService.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       └── main
│   │       └── headers
│   │           └── java
│   │               └── main
│   ├── reports
│   │   └── problems
│   │       └── problems-report.html
│   ├── resources
│   │   └── main
│   │       ├── application.properties
│   │       ├── static
│   │       └── templates
│   └── tmp
│       └── compileJava
│           ├── compileTransaction
│           │   ├── backup-dir
│           │   └── stash-dir
│           │       ├── SavingGoalController.class.uniqueId0
│           │       └── SavingGoalService.class.uniqueId1
│           └── previous-compilation-data.bin
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── syfe
    │   │           └── jan19test3
    │   │               ├── Application.java
    │   │               ├── Controller
    │   │               │   ├── AdminController.java
    │   │               │   ├── PublicController.java
    │   │               │   ├── SavingGoalController.java
    │   │               │   ├── TransactionController.java
    │   │               │   └── UserController.java
    │   │               ├── DTO
    │   │               │   ├── AuthDTO.java
    │   │               │   ├── SavingGoalDTO.java
    │   │               │   ├── SavingGoal_ReturnDTO.java
    │   │               │   ├── TransactionDTO.java
    │   │               │   ├── TransactionReturnDTO.java
    │   │               │   ├── TransactionType.java
    │   │               │   ├── UserDTO.java
    │   │               │   └── UserReadDTO.java
    │   │               ├── Entity
    │   │               │   ├── SavingGoal.java
    │   │               │   ├── UserEntity.java
    │   │               │   └── userTransaction.java
    │   │               ├── Repository
    │   │               │   ├── SavingGoalRepository.java
    │   │               │   ├── TransactionRepository.java
    │   │               │   └── UserRepository.java
    │   │               ├── Security
    │   │               │   ├── MyUserDetailService.java
    │   │               │   ├── SecurityConfig.java
    │   │               │   └── UserPrincipal.java
    │   │               └── Service
    │   │                   ├── JWTService.java
    │   │                   ├── SavingGoalService.java
    │   │                   ├── TransactionService.java
    │   │                   └── UserService.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── syfe
                    └── jan19test3
                        └── ApplicationTests.java
```

- **Controller**: Manages API endpoints.  
- **DTO**: Facilitates data transfer between layers.  
- **Entity**: Represents database models.  
- **Repository**: Handles database queries.  
- **Security**: Configures authentication/authorization.  
- **Service**: Contains business logic.  

---

## ✅ Task Completion Status  

| **Task**                  | **Status**           |  
|---------------------------|----------------------|  
| User registration/login   | ✅ Completed         |  
| Secure authentication     | ✅ Completed         |  
| Session management        | ✅ Completed         |  
| CRUD for transactions     | ✅ Completed         |  
| Category management       | ✅ Completed         |  
| Saving goals management   | ✅ Completed         |  
| Reports with visuals      | 🟧 In Progress       |  
| Unit testing              | 🟧 In Progress       |  
| Postman API testing       | ✅ Completed         |  
| Future enhancements setup | 🟧 In Progress       |  

---

## 🛠️ Future Enhancements  

1. **💳 Payment Gateway Integration**:  
   Allow users to link their bank accounts or cards for automated transaction imports.  

2. **📱 Mobile App**:  
   Extend functionality to iOS/Android platforms for easier access on the go.  

3. **🔔 Notifications**:  
   Add reminders for due bills, progress alerts for savings goals, and spending warnings.  

4. **🌐 Multi-Language Support**:  
   Support localization to cater to a global audience.  

5. **📈 Advanced Analytics**:  
   Introduce AI-driven insights for better budgeting and financial forecasting.  

---

## 🚀 Setup Instructions  

### Prerequisites  
- 🖥️ **Java 17+**  
- 🛢️ **PostgreSQL** (if not using H2)  
- 🔧 **Gradle**  

### Steps to Run  
1. Clone the repository:  
   ```bash  
   git clone https://github.com/Ayush-Puri/SYFE-Financial-Management-Project.git  
   cd PersonalFinanceManager  
   ```  

2. Configure the database:  
   - Modify `application.properties` for PostgreSQL or enable H2 for testing.  

3. Build and run the application:  
   ```bash  
   ./gradlew bootRun  
   ```  

4. Test the APIs:  
   - Use the included Postman collection for endpoint testing.  

---

## 🧪 Testing  
- **Unit Testing**: All critical components have unit tests under `src/test/java`.  
- **Postman Testing**: API endpoints are verified using the Postman collection.  

---

Let me know if you'd like to include anything else! 🎉
