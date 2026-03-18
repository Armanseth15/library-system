package com.library.servlet;

import com.library.dao.MemberDAO;
import com.library.entity.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/addMember")
public class AddMemberServlet extends HttpServlet {

    private final MemberDAO memberDAO = new MemberDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");

            Member member = new Member(name, email, phone);
            memberDAO.save(member);

            response.sendRedirect("members.jsp?success=1");
        } catch (Exception e) {
            response.sendRedirect("members.jsp?error=1");
        }
    }
}