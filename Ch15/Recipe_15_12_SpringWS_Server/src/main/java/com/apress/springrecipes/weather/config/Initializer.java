package com.apress.springrecipes.weather.config;

import org.springframework.web.WebApplicationInitializer;

import org.springframework.web.context.support.XmlWebApplicationContext;

import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletRegistration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class Initializer implements WebApplicationInitializer {
    public void onStartup(ServletContext container)
	throws ServletException {
	
	ServletRegistration.Dynamic springws = container.addServlet("springws", new MessageDispatcherServlet());
	springws.setLoadOnStartup(1);
	springws.addMapping("/*");
    }
}
