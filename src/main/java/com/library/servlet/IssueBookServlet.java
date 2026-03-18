package com.library.servlet;

import com.library.dao.IssueRecordDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/issueBook")
public class IssueBookServlet extends HttpServlet {

    private final IssueRecordDAO issueRecordDAO = new IssueRecordDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int memberId = Integer.parseInt(request.getParameter("memberId"));

            issueRecordDAO.issueBook(bookId, memberId);

            response.sendRedirect("issue-book.jsp?success=1");
        } catch (Exception e) {
            response.sendRedirect("issue-book.jsp?error=1");
        }
    }
}