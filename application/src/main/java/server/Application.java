package server;

import commons.server.DefaultServer;
import commons.database.FlyWayInitializer;
import commons.guice.GuiceListener;
import org.eclipse.jetty.security.ConstraintSecurityHandler;
import org.eclipse.jetty.security.HashLoginService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import server.handlers.SecurityHandlerBuilder;


public class Application {
    public static void main(String[] args) throws Exception {
        FlyWayInitializer.initDB();
        final Server server = new DefaultServer().build();
        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.addServlet(HttpServletDispatcher.class, "/");
        contextHandler.addEventListener(new GuiceListener());

        final String hashConfig = Application.class.getResource("/hash_config").toExternalForm();
        final HashLoginService hashLoginService = new HashLoginService("login", hashConfig);
        ConstraintSecurityHandler securityHandler = new SecurityHandlerBuilder().build(hashLoginService);
        server.addBean(hashLoginService);
        contextHandler.setHandler(securityHandler);

        server.setHandler(contextHandler);
        server.start();
    }
}
