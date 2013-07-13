package com.apress.springrecipes.weather.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;


import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletRegistration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class Initializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext)
	throws ServletException {
        XmlWebApplicationContext context = new XmlWebApplicationContext();
	context.setConfigLocation("/WEB-INF/appContext.xml");
	
	ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
	dispatcher.setLoadOnStartup(1);
	dispatcher.addMapping("/*");
	
    }
}
