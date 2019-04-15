package controller;

import entity.Account;
//import entity.User;
import entity.Feedback;
import model.AccountModel;
import model.UserModel;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        if (username == null) {
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AccountModel model = new AccountModel();

        Account account = model.getAccount(username, password);
        if (account == null) {
            req.setAttribute("username", username);
            req.setAttribute("error", "Tài khoản hoặc mật khẩu không chính xác.");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            return;
        }
        account.getRoles().forEach(r -> System.out.println("role: " + r.getName()));
//        List<String> roles = new ArrayList<>();
//        account.getRoles().forEach(r -> roles.add(r.getName()));
//        String role = "";
//        for (String r:
//                roles) {
//            if (r.equals("admin")) {
//                role = r;
//            }
//        }
//        System.out.println(!role.equals("admin"));
//        System.out.println(role);
        req.setAttribute("username", account.getUsername());
        HttpSession session = req.getSession();
        session.setAttribute("account", account);
        resp.sendRedirect(req.getContextPath() + "/home");

    }
}
