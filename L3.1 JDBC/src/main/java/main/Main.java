package main;


import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.SocketAddressResolver;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class Main {
   public static void main(String[] args) throws Exception {
        initDB();
        initServer();

   }

    private static void initServer() throws Exception {
        SignUpServlet signUpServlet = new SignUpServlet();
        SignInServlet signInServlet = new SignInServlet();
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signUpServlet), "/signup");
        context.addServlet(new ServletHolder(signInServlet), "/signin");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        server.setHandler(handlers);

        System.out.println("Server started");
        server.start();
        server.join();


    }

    private static void initDB(){
        DBService dbService = new DBService();
        dbService.printConnectInfo();
//        try {
//            long userId = dbService.addUser("tully", "yllut");
//            System.out.println("Added user id: " + userId);
//
//            UsersDataSet dataSet = dbService.getUser(userId);
//            System.out.println("User data set: " + dataSet);
//
//            dbService.cleanUp();
//        } catch (DBException e) {
//            e.printStackTrace();
//        }
    }

}
