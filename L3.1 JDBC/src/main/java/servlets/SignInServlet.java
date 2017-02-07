package servlets;

import dbService.DBException;
import dbService.DBService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by moonserk on 15.12.16.
 */
public class SignInServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DBService dbService = new DBService();
        String login = request.getParameter("login");
        //response.getWriter().println(login);
        try {
            if(login.equals(dbService.getUser(login))){
                response.getWriter().println("Authorized: " + login);
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                response.getWriter().println("Unauthorized");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

}
