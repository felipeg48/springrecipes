package com.apress.springrecipes.weather;

import org.springframework.context.support.GenericXmlApplicationContext;

public class RmiServer {

    public static void main(String[] args) {
        new GenericXmlApplicationContext("appContext.xml");
    }
}
