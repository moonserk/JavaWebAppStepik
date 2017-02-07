package servlets;

import accounts.AccountService;
import dbService.DBException;
import dbService.DBService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moonserk on 15.12.16.
 */
public class SignUpServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBService dbService = new DBService();

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DBService dbService = new DBService();
            dbService.addUser(request.getParameter("login"), request.getParameter("password"));
            response.setStatus(HttpServletResponse.SC_OK);

        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}
