package com.company.servlet;

import com.company.model.MyUser;
import com.company.service.MyUserService;
import com.company.service.security.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("loginEmail", "");
        req.getRequestDispatcher("WEB-INF/views/log_in.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("inputEmailForEnter");
        String password = req.getParameter("inputPasswordForEnter");

        MyUserService userService = new MyUserService();
        if (userService.get(email) == null) {
            req.setAttribute("info", "Пользователь не найден");
            req.setAttribute("loginEmail", email);
            req.getRequestDispatcher("WEB-INF/views/log_in.jsp").forward(req,resp);
        } else {
            MyUser user = userService.get(email);
            if (!user.getPassword().equals(MD5Util.md5custom(password))) {
                req.setAttribute("info", "Некорректный пароль");
                req.setAttribute("loginEmail", email);
                req.getRequestDispatcher("WEB-INF/views/log_in.jsp").forward(req,resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("userState", "auth");
                session.setAttribute("userLogin", email);
                if(req.getParameter("saveData") != null){
                    session.setAttribute("saveData","true");
                }
                resp.sendRedirect(getServletContext().getContextPath()+"/");
            }
        }
//        req.getRequestDispatcher("/log_in.jsp").forward(req,resp);
    }
}
