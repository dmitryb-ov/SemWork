package com.company.servlet;

import com.company.model.Group;
import com.company.model.MyUser;
import com.company.model.MyUserGroup;
import com.company.role.MyRoleEnum;
import com.company.service.MyUserGroupService;
import com.company.service.MyUserService;
import com.company.service.security.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("inputEmail", "");
        req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("inputEmail");
        String password = req.getParameter("inputPassword");
        String doublePassword = req.getParameter("confirmPassword");
        String name = req.getParameter("inputName");
        String secondName = req.getParameter("inputSecondName");
        String group = req.getParameter("groupSelect");
        boolean param = true;
        if (!email.equals("") & !password.equals("") & !doublePassword.equals("")
                & !name.equals("") & !secondName.equals("")) {
            if (!Pattern.compile(".+@.+\\..+").matcher(email).find()) {
                req.setAttribute("checkEmail", "Почта написана неверно");
                param = false;
                req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
            }
            if (!password.equals(doublePassword)) {
                req.setAttribute("checkPassword", "Пароли не совпадают");
                param = false;
                req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("checkEmail", "Заполните пустые поля");
            param = false;
            req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
        }

        if (param) {
            MyUserService myUserService = new MyUserService();
            if (myUserService.get(email) != null) {
                req.setAttribute("checkEmail", "Пользователь уже существует");
                req.setAttribute("inputEmail", email);
                req.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(req, resp);
            } else {
                String encryptedPass = MD5Util.md5custom(password);

                MyUser myUser = new MyUser(email, encryptedPass, name, secondName, group, 0, MyRoleEnum.STUDENT);
                myUserService.create(myUser);

                MyUserGroup userGroup = new MyUserGroup(myUser.getEmail(), group);
                MyUserGroupService userGroupService = new MyUserGroupService();
                userGroupService.saveUserGroup(email,userGroup);
                resp.sendRedirect(getServletContext().getContextPath() + "/");
            }
        } else {
            req.setAttribute("inputEmail", email);
        }
    }
}
