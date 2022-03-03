package by.tms.web.servlet.user;

import by.tms.web.servlet.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = Constants.LOGOUT_SERVLET_LINK, name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("username");
        session.removeAttribute("password");
        session.invalidate();
        // resp.getWriter().println("Logout successfully");
        req.setAttribute("messageLogout", "Logout successfully");
        logger.info("Logout successfully");
        req.getServletContext().getRequestDispatcher(Constants.LOGOUT_LINK_JSP).forward(req, resp);
    }
}
