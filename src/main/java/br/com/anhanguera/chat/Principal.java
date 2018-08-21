package br.com.anhanguera.chat;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.util.resource.Resource;

public class Principal {
	
	public static void main(String[] args) throws Exception {

		Server servidor = new Server(8080);

		ServletContextHandler servletHandler =
				new ServletContextHandler(ServletContextHandler.SESSIONS);
		servletHandler.setContextPath("/");
		servletHandler.setBaseResource(Resource.newResource(
				Principal.class.getClassLoader().getResource("html/").toURI()));
		servletHandler.setWelcomeFiles(new String[]{"index.html"});

		ServletHolder holderPadrao = new ServletHolder("padrao", DefaultServlet.class);
		holderPadrao.setInitParameter("dirAllowed", "true");
		servletHandler.addServlet(holderPadrao, "/");


		ServletHolder jerseyServlet = servletHandler.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/api/*");

		jerseyServlet.setInitOrder(0);


		servidor.setHandler(servletHandler);

		servidor.start();
		servidor.join();
	}
}
