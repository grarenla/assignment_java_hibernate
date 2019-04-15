package controller;

import entity.Feedback;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        ArrayList<Feedback> feedbackArrayList = feedbackModel.getList();
        System.out.println("feedback size: " + feedbackArrayList.size());
        req.setAttribute("list", feedbackArrayList);
        req.getRequestDispatcher("view/home.jsp").forward(req, resp);
    }
}
