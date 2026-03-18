<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.library.entity.Book" %>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    if (books == null) {
        response.sendRedirect("home");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Library Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            margin: 0;
            padding: 0;
        }
        .navbar {
            background: #1f3c88;
            padding: 15px 30px;
        }
        .navbar a {
            color: white;
            text-decoration: none;
            margin-right: 20px;
            font-weight: bold;
        }
        .container {
            width: 90%;
            margin: 30px auto;
        }
        .card {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            margin-bottom: 25px;
        }
        h2 {
            margin-top: 0;
            color: #1f3c88;
        }
        input, button {
            padding: 10px;
            margin: 8px 5px 8px 0;
        }
        input {
            width: 220px;
        }
        button {
            background: #1f3c88;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background: #16316f;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background: white;
        }
        table th, table td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: left;
        }
        table th {
            background: #1f3c88;
            color: white;
        }
        .delete-btn {
            color: red;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="navbar">
    <a href="home">Home</a>
    <a href="members.jsp">Members</a>
    <a href="issue-book.jsp">Issue Book</a>
    <a href="return-book.jsp">Return Book</a>
</div>

<div class="container">

    <div class="card">
        <h2>Add Book</h2>
        <form action="addBook" method="post">
            <input type="text" name="title" placeholder="Book Title" required>
            <input type="text" name="author" placeholder="Author" required>
            <input type="text" name="isbn" placeholder="ISBN" required>
            <input type="number" name="quantity" placeholder="Quantity" required>
            <button type="submit">Add Book</button>
        </form>
    </div>

    <div class="card">
        <h2>Book List</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>ISBN</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
                for (Book book : books) {
            %>
            <tr>
                <td><%= book.getId() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getIsbn() %></td>
                <td><%= book.getQuantity() %></td>
                <td>
                    <a class="delete-btn" href="deleteBook?id=<%= book.getId() %>"
                       onclick="return confirm('Delete this book?')">Delete</a>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </div>

</div>

</body>
</html>