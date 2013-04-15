package com.apress.springrecipes.springweb.web;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import com.apress.springrecipes.springweb.services.config.ServicesConfiguration;

public class SpringApplicationContextInitializer implements ApplicationContextInitializer<AnnotationConfigWebApplicationContext> {

    @Override
    public void initialize(AnnotationConfigWebApplicationContext applicationContext) {

	applicationContext.getEnvironment().setActiveProfiles("local");

        Class<?>[] configs = {ServicesConfiguration.class, WebMvcConfiguration.class};

        String[] basePkgs = new String[configs.length];
        int i = 0;
        for (Class<?> pkg : configs)
            basePkgs[i++] = pkg.getPackage().getName();

        applicationContext.scan(basePkgs);
        applicationContext.refresh();
    }
}