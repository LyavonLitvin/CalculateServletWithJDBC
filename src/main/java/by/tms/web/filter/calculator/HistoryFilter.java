package by.tms.web.filter.calculator;

import by.tms.web.filter.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(servletNames = "HistoryServlet")
public class HistoryFilter extends HttpFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            req.setAttribute("messageErrorHistory", Constants.MSG_ERROR_NOT_AUTHORIZED);
            logger.info(Constants.MSG_ERROR_NOT_AUTHORIZED);
            req.getServletContext().getRequestDispatcher(Constants.AUTHORIZATION_LINK_JSP).forward(req, resp);
        }
        chain.doFilter(req, resp);
    }
}