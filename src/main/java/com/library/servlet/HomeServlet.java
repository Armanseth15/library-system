package com.library.servlet;

import com.library.dao.BookDAO;
import com.library.dao.IssueRecordDAO;
import com.library.dao.MemberDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private final BookDAO bookDAO = new BookDAO();
    private final MemberDAO memberDAO = new MemberDAO();
    private final IssueRecordDAO issueRecordDAO = new IssueRecordDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("books", bookDAO.getAll());
        request.setAttribute("members", memberDAO.getAll());
        request.setAttribute("issues", issueRecordDAO.getAll());

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}