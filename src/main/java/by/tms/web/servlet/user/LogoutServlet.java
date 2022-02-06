package by.tms.web.servlet.user;

import by.tms.service.CalculatorService;
import by.tms.service.InMemoryUsersStorageService;
import by.tms.web.servlet.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGOUT_SERVLET_LINK, name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CalculatorService calculatorService = new CalculatorService();
        InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();
        HttpSession session = req.getSession();
        calculatorService.deleteResults();
        System.out.println("Results have deleted successfully");
        inMemoryUsersStorageService.deleteUsers();
        System.out.println("Users have deleted successfully");
        session.removeAttribute("username");
        session.invalidate();
        // resp.getWriter().println("Logout successfully");
        req.setAttribute("messageLogout", "Logout successfully");
        req.getServletContext().getRequestDispatcher(Constants.LOGOUT_LINK_JSP).forward(req, resp);
    }
}
