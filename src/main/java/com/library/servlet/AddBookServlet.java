package com.library.servlet;

import com.library.dao.BookDAO;
import com.library.entity.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    private final BookDAO bookDAO = new BookDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String isbn = request.getParameter("isbn");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Book book = new Book(title, author, isbn, quantity);
            bookDAO.save(book);

            response.sendRedirect("home");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("home").forward(request, response);
        }
    }
}