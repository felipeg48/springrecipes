package com.apress.springrecipes.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class WeatherConfigJaxWsServer {
    @Bean
    public SimpleJaxWsServiceExporter jaxWsService() { 
	SimpleJaxWsServiceExporter simpleJaxWs = new SimpleJaxWsServiceExporter();
	simpleJaxWs.setBaseAddress("http://localhost:8888/jaxws/");
	return simpleJaxWs;
    }
}
