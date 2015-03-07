
package com.master.core.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.util.ClassUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 * @author Xiang Li
 * 
 */
public class ServletInitializer extends AbstractDispatcherServletInitializer {
	
	@Override
	protected WebApplicationContext createServletApplicationContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		//need to change, when remname the package name
		context.scan(ClassUtils.getPackageName(getClass()),"com.master.rest.controller");
		return context;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected WebApplicationContext createRootApplicationContext() {
		return null;
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		DelegatingFilterProxy filter = new DelegatingFilterProxy("springSecurityFilterChain");
		filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
		
		/*servletContext.addFilter("springSecurityFilterChain", filter)
			.addMappingForUrlPatterns(null, false, "/*");*/
		
		Dynamic reg = servletContext.addFilter("springSecurityFilterChain", filter);
		reg.addMappingForUrlPatterns(null, false, "/*");
	}		
	@Override
	protected Filter[] getServletFilters() {
		//CORS: Enables cross-origin requests, allow grab resources from different domains
		SimpleCORSFilter simpleCORSFilter = new SimpleCORSFilter();
	    return new Filter[] { simpleCORSFilter};
	}
	
}
