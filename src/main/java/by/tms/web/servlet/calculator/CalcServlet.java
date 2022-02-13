package by.tms.web.servlet.calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.tms.service.*;
import by.tms.entity.Result;
import by.tms.web.servlet.Constants;

@WebServlet(urlPatterns = Constants.CALCULATION_SERVLET_LINK, name = "CalcServlet")
public class CalcServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        ResultService resultService = new ResultService();
        UserService userService = new UserService();
        HttpSession session = req.getSession();
        String firstNumberString = req.getParameter("num1");
        String secondNumberString = req.getParameter("num2");
        String operationType = req.getParameter("opType");
        double firstNumber = Double.parseDouble(firstNumberString);
        double secondNumber = Double.parseDouble(secondNumberString);
        Result result = new Result(firstNumber, secondNumber, operationType, userService.getUserId((String) session.getAttribute("username")));
        resultService.calculation(result);
        req.setAttribute("results",resultService.getResults(userService.getUserId((String) session.getAttribute("username"))));
        req.setAttribute("messageCalculator", result.toString());
        req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
    }
}
