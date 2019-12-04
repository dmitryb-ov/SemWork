package com.company.servlet;

import com.company.model.MyUser;
import com.company.role.MyRoleEnum;
import com.company.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final String STUDENT = "Студент";
    private static final String TEACHER = "Преподаватель";
    private static final String ADMIN = "Администрация";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = (String) session.getAttribute("userLogin");
        MyUserService myUserService = new MyUserService();
        MyUser myUser = myUserService.get(email);
        String role = "";
        if (myUser.getRole() == MyRoleEnum.STUDENT) {
            role = STUDENT;
        }
        if (myUser.getRole() == MyRoleEnum.ADMIN) {
            role = ADMIN;
        }
        if (myUser.getRole() == MyRoleEnum.TEACHER) {
            role = TEACHER;
        }
        String userName = myUser.getName();
        String userSecondName = myUser.getSecondName();

        req.setAttribute("userNameAll", userName + " " + userSecondName); //user.getName();
        req.setAttribute("userType", role);
        req.setAttribute("userName",userName);
        req.setAttribute("userSecondName",userSecondName);
        req.setAttribute("userGroup",myUser.getGroupId());
        req.setAttribute("userPoints",myUser.getPoints());

        req.getRequestDispatcher("WEB-INF/views/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
