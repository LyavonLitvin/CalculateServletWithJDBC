package by.tms.web.filter.user;

import by.tms.service.InMemoryUsersStorageService;
import by.tms.web.filter.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {
    InMemoryUsersStorageService inMemoryUsersStorageService = new InMemoryUsersStorageService();

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("POST")) {
            String userName = req.getParameter("username");
            String password = req.getParameter("password");
            if (userName == null || password == null) {
                req.setAttribute("messageErrorAuthorization", Constants.MSG_ERROR_USERNAME_OR_PASSWORD_NULL);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            } else if (userName.isEmpty() || password.isEmpty()) {
                req.setAttribute("messageErrorAuthorization", Constants.MSG_ERROR_USERNAME_OR_PASSWORD_EMPTY);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUser(userName)) {
                req.setAttribute("messageErrorAuthorization", Constants.MSG_ERROR_USER_NOT_FOUND);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            } else if (!inMemoryUsersStorageService.checkUserByUsernamePassword(userName, password)) {
                req.setAttribute("messageErrorAuthorization", Constants.MSG_ERROR_PASSWORD_IS_INCORRECT);
                req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
            }
        }
        chain.doFilter(req, resp);
    }
}
