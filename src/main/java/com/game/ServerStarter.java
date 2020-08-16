package com.game;

import com.game.controllers.BaysController;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class ServerStarter {
    public void startServer() {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/api");
//        context.addServlet(new ServletHolder(new ShipsController()), "/ship/all");
//        context.addServlet(new ServletHolder(new DialogsController()), "/dialog/all");
//        context.addServlet(new ServletHolder(new AchievementsController()), "/achievement/all");
//        context.addServlet(new ServletHolder(new FightersController()), "/fighter/all");
//        context.addServlet(new ServletHolder(new WeaponsController()), "/weapon/all");
//        context.addServlet(new ServletHolder(new NotificationsController()), "/notification/all");
//        context.addServlet(new ServletHolder(new BaysController()), "/bay/all");
//        context.addServlet(new ServletHolder(new UpdatesController()), "/update/all");        server.setHandler(context);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}

