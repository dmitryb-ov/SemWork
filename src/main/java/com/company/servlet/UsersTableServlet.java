package com.company.servlet;

import com.company.model.MyUser;
import com.company.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersTableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/users_table.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("inputNumber");
        for (int i = 0; i < userId.length(); i++) {
            if(userId.charAt(i) < '0' || userId.charAt(i) > '9'){
                req.setAttribute("error","Введены не только цифры");
                return;
            }
        }
        MyUserService userService = new MyUserService();
        List<MyUser> users = userService.getAll();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == Integer.parseInt(userId)){
                userService.delete(users.get(i).getEmail());
                break;
            }
        }
        resp.sendRedirect(getServletContext().getContextPath()+"/users");
    }
}
