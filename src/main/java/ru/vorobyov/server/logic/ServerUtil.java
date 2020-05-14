package ru.vorobyov.server.logic;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.vorobyov.server.servlets.AllRequestionServlet;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerUtil {

    Logger logger = Logger.getLogger(ServerUtil.class.getName());

    public ServerUtil() {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new AllRequestionServlet()), "/");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            logger.log(Level.INFO, "Server started");
        } catch (Exception e) {
            logger.log(Level.WARNING, "Server did not start");
        }

        try {
            server.join();
        } catch (InterruptedException e) {
            logger.log(Level.WARNING, "Server did not start");
        }
    }
}
