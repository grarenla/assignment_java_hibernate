package controller;

import entity.Account;
import entity.Feedback;
//import entity.User;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/feedback")
public class FeedbackController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/feedback-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null) account = new Account();
        Feedback feedback = new Feedback();
        feedback.setTitle(req.getParameter("title"));
        feedback.setDescription(req.getParameter("description"));
//        feedback.setUserId(account.getId());
        feedback.setAccount(account);
        if (!feedback.isValid()) {
            req.setAttribute("errors", feedback.getErrors());
            req.setAttribute("feedback", feedback);
            req.getRequestDispatcher("view/feedback-form.jsp").forward(req, resp);
            return;
        }
        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.insert(feedback);
        req.setAttribute("success", "Gửi feedback thành công.");
        doGet(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.delete(id);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.update(id);
    }
}
