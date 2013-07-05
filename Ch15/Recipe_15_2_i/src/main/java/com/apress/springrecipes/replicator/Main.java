package com.apress.springrecipes.replicator;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws IOException {
        ApplicationContext context =
            new GenericXmlApplicationContext("beans-jmx.xml");
        System.in.read();

    }
}
