package com.company.servlet;

import com.company.model.MyUser;
import com.company.service.MyUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mygroup")
public class MyGroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MyUserService userService = new MyUserService();
        List<MyUser> users = userService.getAll();
        List<MyUser> myGroupUser = new ArrayList<>();

        Cookie[] cookies = req.getCookies();
        String cookeName = "mySortGroupType";
        Cookie cookie = null;
        HttpSession session = req.getSession();
        String userMail = (String) session.getAttribute("userLogin");
        MyUser user = userService.get(userMail);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getGroupId().equals(user.getGroupId())) {
                myGroupUser.add(users.get(i));
            }
        }
        myGroupUser.add(user);

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (cookeName.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
            if (cookie != null) {
                if (cookie.getValue().equals("sort_name_value")) {
                    myGroupUser.sort((o1, o2) -> {
                        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
                        if (res == 0) {
                            res = o1.getName().compareTo(o2.getName());
                        }
                        return res;
                    });
//                    req.setAttribute("sortType",1);
                }
                if (cookie.getValue().equals("sort_secondName_value")) {
                    myGroupUser.sort((o1, o2) -> {
                        int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getSecondName(), o2.getSecondName());
                        if (res == 0) {
                            res = o1.getSecondName().compareTo(o2.getSecondName());
                        }
                        return res;
                    });
//                    req.setAttribute("sortType",2);
                }
                if (cookie.getValue().equals("sort_points_value")) {
                    myGroupUser.sort((o1, o2) -> {
                        Integer p1 = o1.getPoints();
                        Integer p2 = o2.getPoints();
                        int res = p1.compareTo(p2);
                        if (res == 0) {
                            res = p1.compareTo(p2);
                        }
                        return res;
                    });
                }
//                    req.setAttribute("sortType",3);
            }
        }
        req.setAttribute("myGroups", myGroupUser);
        req.getRequestDispatcher("WEB-INF/views/my_group.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortType = req.getParameter("sortSelect");
        Cookie cookie = new Cookie("mySortGroupType", sortType);
        if (sortType == null) {
            cookie.setMaxAge(0);
        } else {
            resp.addCookie(cookie);
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/mygroup");
    }
}
