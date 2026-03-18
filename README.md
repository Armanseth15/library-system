# 📚 Library Management System

A modern and efficient **Library Management System** built using **Java, JSP, Servlets, and MySQL**.  
This project helps manage books, members, and transactions like issuing and returning books with ease.

---

## 🚀 Features

✨ Add, update, and delete books  
✨ Manage library members  
✨ Issue and return books  
✨ Track available and issued books  
✨ Session-based authentication  
✨ Clean and minimal user interface  

---

## 🛠️ Tech Stack

- 💻 Java (Servlets, JSP)
- 🌐 HTML, CSS
- 🗄️ MySQL Database
- 🔗 JDBC
- ⚙️ Apache Tomcat
- 🧠 MVC Architecture

---

## 📂 Project Structure

```text
LibraryManagementSystem/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/library/
│       │       ├── HomeServlet.java
│       │       ├── AddBookServlet.java
│       │       ├── DeleteBookServlet.java
│       │       ├── AddMemberServlet.java
│       │       ├── IssueBookServlet.java
│       │       └── ReturnBookServlet.java
│       │
│       └── webapp/
│           ├── index.jsp
│           ├── dashboard.jsp
│           ├── addBook.jsp
│           ├── issueBook.jsp
│           └── WEB-INF/
│               └── web.xml
│
├── pom.xml
└── README.md
