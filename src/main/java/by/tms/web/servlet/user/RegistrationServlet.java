package by.tms.web.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.tms.entity.User;
import by.tms.service.InMemoryUsersStorageService;
import by.tms.web.servlet.Constants;

//registration?name=leo&username=leo&password=leo
@WebServlet(urlPatterns = Constants.REGISTRATION_SERVLET_LINK, name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, NullPointerException, ServletException {
        InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();
        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        session.setAttribute("username", userName);
        User user = new User(name, userName, password, session.getId());
        if (inMemoryUsersStorageService.saveUser(user)) {
            session.setAttribute("messageErrorRegistration","Registration was successful.");
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
        } else {
            session.setAttribute("messageErrorRegistration","Error. User not created.");
            req.getServletContext().getRequestDispatcher(Constants.INDEX_LINK_JSP).forward(req, resp);
        }
    }
}
