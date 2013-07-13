package com.apress.springrecipes.weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apress.springrecipes.weather.WeatherService;
import com.apress.springrecipes.weather.WeatherServiceImpl;

@Configuration
public class WeatherConfigHTTPInvokerServer {
    
    @Bean
    public WeatherService weatherService() { 
	WeatherService wService = new WeatherServiceImpl();
	return wService;
    }
    
}
