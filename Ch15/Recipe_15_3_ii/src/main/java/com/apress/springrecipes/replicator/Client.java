package com.apress.springrecipes.replicator;

import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Client {

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
            new GenericXmlApplicationContext("beans-jmx-client.xml");

        FileReplicator fileReplicatorProxy =
            (FileReplicator) context.getBean("fileReplicatorProxy");

        String srcDir = fileReplicatorProxy.getSrcDir();
        fileReplicatorProxy.setDestDir(srcDir + "_backup");
        fileReplicatorProxy.replicate();
    }
}
