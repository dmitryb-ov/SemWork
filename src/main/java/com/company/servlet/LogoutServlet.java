package com.company.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession httpSession = req.getSession();
//        if(httpSession.getAttribute("userState") == "auth"){
//            httpSession.removeAttribute("userState");
//        }
//        resp.sendRedirect(getServletContext().getContextPath()+"/");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(httpSession.getAttribute("userState") == "auth"){
            httpSession.removeAttribute("userState");
            httpSession.removeAttribute("saveData");
            httpSession.removeAttribute("userLogin");
        }
        resp.sendRedirect(getServletContext().getContextPath()+"/");
    }
}
