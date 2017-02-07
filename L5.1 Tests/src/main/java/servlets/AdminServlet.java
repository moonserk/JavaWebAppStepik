package servlets;

import accountServer.AccountServerI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moonserk on 22.12.16.
 */
public class AdminServlet extends HttpServlet {
    static final Logger logger = LogManager.getLogger(AdminServlet.class.getName());
    public static final String URL_PAGE = "/admin";
    private final AccountServerI accountServer;

    public AdminServlet(AccountServerI accountServer) {
        this.accountServer = accountServer;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(accountServer.getUsersLimit());
    }
}
