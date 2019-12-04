package com.company.servlet;

import com.company.model.MyUser;
import com.company.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SortingTable extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String cookeName = "mySortType";
        Cookie cookie = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookeName.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
            if(cookie != null) {
                MyUserService userService = new MyUserService();
                List<MyUser> userList = userService.getAll();
                if (cookie.getValue().equals("sort_email_value")) {
                userList.sort((o1, o2) -> {
                    int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getEmail(), o2.getEmail());
                    if (res == 0) {
                        res = o1.getEmail().compareTo(o2.getEmail());
                    }
                    return res;
                });
                req.setAttribute("myval",1);
//                req.setAttribute("sort",userList);
//                req.setAttribute("myval",1);
                } else if (cookie.getValue().equals("sort_password_value")) {
                userList.sort((o1, o2) -> {
                    int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getPassword(), o2.getPassword());
                    if (res == 0) {
                        res = o1.getEmail().compareTo(o2.getPassword());
                    }
                    return res;
                });
                req.setAttribute("myval",0);
//                req.setAttribute("sort",userList);
//                req.setAttribute("myval", 0);
                }
            }
        }
        req.getRequestDispatcher("/sort_table_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortType = req.getParameter("sort");
        Cookie cookie = new Cookie("mySortType", sortType);
        if(sortType == null){
            cookie.setMaxAge(0);
        } else {
            resp.addCookie(cookie);
        }
        resp.sendRedirect(getServletContext().getContextPath()+"/sort");
//        req.getRequestDispatcher("/sort_table_page.jsp").forward(req,resp);
//        resp.sendRedirect("./sort");
    }
}
