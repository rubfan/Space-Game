package com.game;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ServerStarter {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.setContextPath("/");

        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("com.game.controllers");

        ServletContainer servletContainer = new ServletContainer(resourceConfig);
        ServletHolder sh = new ServletHolder(servletContainer);
        context.addServlet(sh, "/api/*");

        server.setHandler(context);

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
