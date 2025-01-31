
# SYFE Financial Management Project

## Overview
SYFE Financial Management Project is a RESTful API that provides endpoints for managing savings goals, user accounts, transactions, and reports. The system ensures security and data isolation by requiring authentication for all non-public endpoints.

## Table of Contents
- [Features](#features)
- [Authentication](#authentication)
- [API Endpoints](#api-endpoints)
  - [Public Endpoints](#public-endpoints)
  - [User Endpoints](#user-endpoints)
  - [Transaction Endpoints](#transaction-endpoints)
  - [Admin Endpoints](#admin-endpoints)
  - [Report Endpoints](#report-endpoints)
- [Setup and Running the Project](#setup-and-running-the-project)
- [Security Considerations](#security-considerations)

## Features
- User authentication and authorization
- Savings goal management
- Transaction management
- Report generation
- Secure data isolation per user

## Authentication
All non-public endpoints require authentication using **Basic Authentication** with the format:
```
Authorization: Basic <username> <password>
```
- This ensures that users can only access and modify their own data.
- Transactions and saving goals are linked to the authenticated user, preventing unauthorized changes by other users.

  
## Table Structure with Relations
---<img width="854" alt="Screenshot 2025-01-20 at 10 16 23 AM" src="https://github.com/user-attachments/assets/d136fbd3-8393-47a9-b959-b36158ab3a49" />


## API Endpoints
### Public Endpoints
These endpoints do not require authentication.

#### Signup a new user
```http
POST http://localhost:8080/public/signup
Content-Type: application/json

{
  "username": "",
  "email": "",
  "password": ""
}
```
#### Verify user
```http
POST http://localhost:8080/public/verify
```

### User Endpoints
Require authentication.

#### Get all users
```http
GET http://localhost:8080/api/allusers
Authorization: Basic <username> <password>
```
#### Get user details
```http
GET http://localhost:8080/api/user
Authorization: Basic <username> <password>
```
#### Update user details
```http
PUT http://localhost:8080/api/user
Authorization: Basic <username> <password>
```
#### Delete user
```http
DELETE http://localhost:8080/api/user
Authorization: Basic <username> <password>
```

### Transaction Endpoints
Require authentication.

#### Commit a transaction
```http
POST http://localhost:8080/transaction/commit
Content-Type: application/json
Authorization: Basic <username> <password>

{
  "amount": 0,
  "type": "Income",
  "category": "",
  "description": ""
}
```
#### Update a transaction
```http
PUT http://localhost:8080/transaction/commit/{transactionId}
Authorization: Basic <username> <password>
```
#### View all transactions
```http
GET http://localhost:8080/transaction/viewAll
Authorization: Basic <username> <password>
```

### Admin Endpoints
Require authentication with admin privileges.

#### Delete a user
```http
DELETE http://localhost:8080/admin/user/{userId}
Authorization: Basic <admin_username> <admin_password>
```

### Report Endpoints
Require authentication.

#### View report
```http
GET http://localhost:8080/report
Authorization: Basic <username> <password>
```
#### View report for a specific year
```http
GET http://localhost:8080/report/{year}
Authorization: Basic <username> <password>
```

## Setup and Running the Project
1. Clone the repository:
```sh
git clone https://github.com/Ayush-Puri/SYFE-Financial-Management-Project.git
cd SYFE-Financial-Management-Project
```
2. Build the project using Gradle:
```sh
gradle build
```
3. Run the application:
```sh
java -jar build/libs/SYFE-Financial-Management-Project.jar
```

## Security Considerations
- **Authentication is mandatory for all non-public endpoints**. Without it, users will encounter authentication errors.
- **Data Isolation:** Each user's transactions and savings goals are tied to their account, preventing unauthorized modifications.
- **Admin Privileges:** Only admins can perform certain actions like deleting users.

---

