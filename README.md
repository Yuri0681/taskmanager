# 📝 Task Management App (Spring Boot + Thymeleaf)

This is a simple task management application built with Spring Boot and Thymeleaf.  
Users can register an account, log in, and manage their personal tasks with features like create, edit, and delete.

## 🔧 Technologies Used

- **Backend**: Spring Boot, Spring MVC, Spring Data JPA, Spring Security
- **Templating**: Thymeleaf
- **Database**: H2 (in-memory)
- **Build Tool**: Maven
- **Styling**: CSS, JavaScript (optional)

## 📋 Features

| Feature        | Description                                 |
|----------------|---------------------------------------------|
| User Registration | Register with a username and password     |
| Login / Logout   | Authentication handled by Spring Security |
| Task Listing     | View a list of tasks for the logged-in user |
| Create Task      | Add tasks with title, due date, and status |
| Edit / Delete Task | Update or remove existing tasks           |

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2. Run the Application
```bash
./mvnw spring-boot:run
```
Or run TaskManagementApplication.java from your IDE (IntelliJ, Eclipse, etc.).

### 3. Open in Browser
Access the app at:
http://localhost:8080

## 👤 Demo Account
Username: admin  
Password: 1234

## 📁 Project Structure
```bash
src
├── main
│   ├── java
│   │   └── com.example.taskmanager
│   │       ├── controller
│   │       ├── model
│   │       ├── repository
│   │       ├── security
│   │       └── service
│   └── resources
│       ├── templates
│       └── static
└── test
    └── java
```

## 🔐 Security
**・** Spring Security-based authentication
**・** Passwords encrypted using BCrypt
**・** CSRF protection enabled

## 🧠 Notes
This application was created as a portfolio project to demonstrate full-stack development using Spring Boot.
AI tools were used to assist in development, but all code was written with understanding and intent.
