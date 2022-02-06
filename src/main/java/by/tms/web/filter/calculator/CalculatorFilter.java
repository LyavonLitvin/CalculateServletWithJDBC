package by.tms.web.filter.calculator;

import by.tms.service.InMemoryUsersStorageService;
import by.tms.validator.CalculatorValidator;
import by.tms.web.filter.Constants;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "CalcServlet")
public class CalculatorFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {

        CalculatorValidator validator = new CalculatorValidator();
        if (req.getMethod().equals("POST")) {
            HttpSession session = req.getSession();
            if (session.getAttribute("username") == null) {
                req.setAttribute("messageErrorCalculator", Constants.MSG_ERROR_NOT_AUTHORIZED);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUser((String) session.getAttribute("username"))) {
                req.setAttribute("messageErrorCalculator", Constants.MSG_ERROR_NOT_AUTHORIZED);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            } else {
                String firstNumberString = req.getParameter("num1");
                String secondNumberString = req.getParameter("num2");
                String operationType = req.getParameter("opType");
                if (firstNumberString == null || secondNumberString == null || operationType == null) {
                    req.setAttribute("messageErrorCalculator", Constants.MSG_ERROR_ONE_OF_THE_FIELDS_IS_NULL);
                    req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
                } else if (firstNumberString.isEmpty() || secondNumberString.isEmpty() || operationType.isEmpty()) {
                    req.setAttribute("messageErrorCalculator", Constants.MSG_ERROR_ONE_OF_THE_FIELDS_IS_EMPTY);
                    req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
                } else if (!validator.isNumeric(firstNumberString) && !validator.isNumeric(secondNumberString) && !validator.isRightOperator(operationType)) {
                    req.setAttribute("messageErrorCalculator", Constants.MSG_ERROR_WRONG_ENTER_NUMBERS_OR_OPERATION_TYPE);
                    req.getServletContext().getRequestDispatcher(Constants.CALCULATOR_LINK_JSP).forward(req, resp);
                }
            }
        }
        chain.doFilter(req, resp);
    }
}

// <p>${requestScope.message}</p>