package nl.maartenwinkels.web.security;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.DelegatingFilterProxy;

@WebListener
public class SpringSecurityInitializer implements ServletContextListener {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SpringSecurityInitializer.class);
	
	private static final String FILTER_NAME = "springSecurityFilterChain";

	@Override
	public void contextInitialized(ServletContextEvent event) {
		LOGGER.debug("Initializing spring security.");
		ServletContext servletContext = event.getServletContext();
		servletContext
			.addFilter(FILTER_NAME, new DelegatingFilterProxy(FILTER_NAME))
			.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD), false, "/*");
		LOGGER.debug("Spring security initialized.");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
