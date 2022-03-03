package by.tms.web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.tms.entity.User;
import by.tms.service.UserService;
import by.tms.web.servlet.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//registration?name=leo&username=leo&password=leo
@WebServlet(urlPatterns = Constants.REGISTRATION_SERVLET_LINK, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        logger.info("Go to registration page");
        req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        UserService userService = new UserService();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        int roleId = req.getIntHeader("roleId");
        String email = req.getParameter("email");
        String secretQuestion = req.getParameter("secretQuestion");
        session.setAttribute("username", userName);
        User user = new User(roleId,name,userName,password,email,secretQuestion);
        logger.info("Data go to service");
        if (userService.addUser(user)) {
            session.setAttribute("messageErrorRegistration","Registration was successful.");
            logger.info("Registration was successful.");
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
        } else {
            session.setAttribute("messageErrorRegistration","Error. User not created.");
            logger.info("Error. User not created.");
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
        }
    }
}
