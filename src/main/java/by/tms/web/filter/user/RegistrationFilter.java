package by.tms.web.filter.user;

import by.tms.service.UserService;
import by.tms.web.filter.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {

    UserService userService = new UserService();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String name = req.getParameter("name");
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            if (name == null || userName == null || password == null) {
                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_NULL);
                logger.info(Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_NULL);
                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
            } else if (name.isEmpty() || userName.isEmpty() || password.isEmpty()) {
                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_EMPTY);
                logger.info(Constants.MSG_ERROR_NAME_USERNAME_PASSWORD_EMPTY);
                req.getServletContext().getRequestDispatcher(Constants.REGISTRATION_LINK_JSP).forward(req, resp);
            } else if (userService.checkByUserLogin(userName)) {
                req.setAttribute("messageErrorRegistration", Constants.MSG_ERROR_USER_HAS_FOUND);
                logger.info(Constants.MSG_ERROR_USER_HAS_FOUND);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }
}
