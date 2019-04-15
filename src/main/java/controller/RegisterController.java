package controller;

import entity.Account;
//import entity.User;
import entity.Role;
import entity.UserInformation;
import model.AccountModel;
import model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@WebServlet("/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/Assignment_war_exploded/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        UserModel userModel = new UserModel();
//        User user = new User();
//        user.setUsername(req.getParameter("username"));
//        user.setPassword(req.getParameter("password"));
//        user.setFullName(req.getParameter("fullName"));


//        if (!user.isValid()) {
//            req.setAttribute("errors", user.getErrors());
//            req.setAttribute("user", user);
//            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
//            return;
//        }
//        userModel.insert(user);


        Account account = new Account();
        account.setUsername(req.getParameter("username"));
        account.setPassword(req.getParameter("password"));
        UserInformation userInformation = new UserInformation();
        userInformation.setFullName(req.getParameter("fullName"));
        userInformation.setEmail(req.getParameter("email"));
        account.setUserInformation(userInformation);

        Role role = new Role();
        role.setName("user");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        account.setRoles(roles);
        AccountModel accountModel = new AccountModel();

        if (!account.isValid()) {
            req.setAttribute("errors", account.getErrors());
            req.setAttribute("account", account);
            req.setAttribute("userInformation", userInformation);
            req.getRequestDispatcher("view/register.jsp").forward(req, resp);
            return;
        }
        accountModel.insert(account);
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
