package com.apress.springrecipes.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.apress.springrecipes.weather.WeatherServiceClient;
import com.apress.springrecipes.weather.WeatherService;

@Configuration
public class WeatherConfigClient {
    
    @Bean
    public RmiProxyFactoryBean weatherService() {
	RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
	rmiProxy.setServiceUrl("rmi://localhost:1099/WeatherService");
	rmiProxy.setServiceInterface(com.apress.springrecipes.weather.WeatherService.class);
	return rmiProxy;
    }

    @Bean
    public WeatherServiceClient weatherClient() { 
	WeatherServiceClient wServiceClient = new WeatherServiceClient();
	return wServiceClient;
    }


}
