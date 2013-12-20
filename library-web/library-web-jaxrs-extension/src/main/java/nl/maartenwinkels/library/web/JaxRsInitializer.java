package nl.maartenwinkels.library.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.WebListener;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.jersey.spi.container.servlet.ServletContainer;

@WebListener
public class JaxRsInitializer implements ServletContextListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JaxRsInitializer.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		LOGGER.debug("Retrieved application context");
		DynamicSpringJaxRsApplication application = new DynamicSpringJaxRsApplication(applicationContext);
		application.getSingletons().add(new JacksonJsonProvider());
		Dynamic servlet = servletContext.addServlet("jersey", new ServletContainer(application));
		servlet.addMapping("/api/*");
		servlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
}
