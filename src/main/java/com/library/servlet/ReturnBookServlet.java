package com.library.servlet;

import com.library.dao.IssueRecordDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/returnBook")
public class ReturnBookServlet extends HttpServlet {

    private final IssueRecordDAO issueRecordDAO = new IssueRecordDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int issueId = Integer.parseInt(request.getParameter("issueId"));

            issueRecordDAO.returnBook(issueId);

            response.sendRedirect("return-book.jsp?success=1");
        } catch (Exception e) {
            response.sendRedirect("return-book.jsp?error=1");
        }
    }
}