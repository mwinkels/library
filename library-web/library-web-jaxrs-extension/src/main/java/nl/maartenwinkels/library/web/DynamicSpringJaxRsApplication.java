package nl.maartenwinkels.library.web;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class DynamicSpringJaxRsApplication extends Application {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicSpringJaxRsApplication.class);

	private final Set<Object> singletons = new HashSet<>();

	public DynamicSpringJaxRsApplication(ApplicationContext applicationContext) {
		addBeans(applicationContext, Path.class);
		addBeans(applicationContext, Provider.class);
	}

	private void addBeans(ApplicationContext applicationContext, Class<? extends Annotation> annotationType) {
		Collection<Object> beans = applicationContext.getBeansWithAnnotation(annotationType).values();
		LOGGER.debug("Adding beans: {}.", beans);
		singletons.addAll(beans);
	}
	
	@Override
	public Set<Object> getSingletons() {
		LOGGER.debug("Singletons requested: {}", singletons);
		return singletons;
	}

}
