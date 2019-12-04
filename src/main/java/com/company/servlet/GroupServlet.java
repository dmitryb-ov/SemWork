package com.company.servlet;

import com.company.model.Group;
import com.company.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class GroupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        List<Group> group = groupService.getAll();
        req.setAttribute("groups",group);
        req.getRequestDispatcher("WEB-INF/views/groups.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String group = req.getParameter("inputGroup");
        GroupService groupService = new GroupService();
        Group group1 = new Group(2000,group);
        groupService.add(group1);
        resp.sendRedirect(getServletContext().getContextPath()+"/groups");
    }
}
