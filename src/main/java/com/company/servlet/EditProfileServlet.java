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
import java.nio.charset.StandardCharsets;

@WebServlet("/editprofile")
public class EditProfileServlet extends HttpServlet {
    private static final String STUDENT = "Студент";
    private static final String TEACHER = "Преподаватель";
    private static final String ADMIN = "Администрация";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUserService userService = new MyUserService();
        HttpSession session = req.getSession();
        String userEmail = "";
        if (session.getAttribute("userLogin") != null) {
            userEmail = session.getAttribute("userLogin").toString();
        }
        MyUser user = userService.get(userEmail);
        String userName = user.getName();
        String secondName = user.getSecondName();
        req.setAttribute("userNameAll", userName + " " + secondName);

        String role = "";
        if (user.getRole() == MyRoleEnum.STUDENT) {
            role = STUDENT;
        }
        if (user.getRole() == MyRoleEnum.ADMIN) {
            role = ADMIN;
        }
        if (user.getRole() == MyRoleEnum.TEACHER) {
            role = TEACHER;
        }

        req.setAttribute("userType", role);
        req.setAttribute("userOldName", userName);
        req.setAttribute("userOldSecondName", secondName);
        req.getRequestDispatcher("WEB-INF/views/edit_profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String userNewName = req.getParameter("userNewName");
        String userNewSecondName = req.getParameter("userNewSecondName");
        byte[] test = userNewName.getBytes(StandardCharsets.ISO_8859_1);
        byte[] test2 = userNewSecondName.getBytes(StandardCharsets.ISO_8859_1);
        String name = new String(test, StandardCharsets.UTF_8);
        String secondName = new String(test2, StandardCharsets.UTF_8);
        MyUserService userService = new MyUserService();
        HttpSession session = req.getSession();
        String email = "";
        if(session.getAttribute("userLogin") != null){
            email = session.getAttribute("userLogin").toString();
        }
        System.out.println("FDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        MyUser user = userService.get(email);
        user.setName(name);
        user.setSecondName(secondName);
        userService.update(email, user);
        resp.sendRedirect(getServletContext().getContextPath()+"/profile");
    }
}
