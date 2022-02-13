package by.tms.web.servlet.calculator;

import by.tms.entity.Result;
import by.tms.service.ResultService;
import by.tms.service.UserService;
import by.tms.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = Constants.HISTORY_SERVLET_LINK, name = "HistoryServlet")
public class HistoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ResultService resultService = new ResultService();
        UserService userService = new UserService();
        ArrayList<String> results = resultService.getResults(userService.getUserId((String) session.getAttribute("username")));
        req.setAttribute("results", results);

        req.getServletContext().getRequestDispatcher(Constants.HISTORY_LINK_JSP).forward(req, resp);
    }

}
