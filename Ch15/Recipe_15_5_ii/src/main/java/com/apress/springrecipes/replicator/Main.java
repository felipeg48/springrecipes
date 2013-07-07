package com.apress.springrecipes.replicator;

import org.quartz.JobDetail;
import org.quartz.JobDataMap;
import org.quartz.JobBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder.IntervalUnit.*;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext context =
            new GenericXmlApplicationContext("beans.xml");

        FileReplicator documentReplicator =
            (FileReplicator) context.getBean("documentReplicator");

	JobDataMap jobDataMap = new JobDataMap();
	jobDataMap.put("fileReplicator", documentReplicator);

	JobDetail job = JobBuilder.newJob(FileReplicationJob.class)
	    .withIdentity("documentReplicationJob")
	    .storeDurably()
	    .usingJobData(jobDataMap)
	    .build();
     
	Trigger trigger = TriggerBuilder.newTrigger()
	    .withIdentity("documentReplicationTrigger")
	    .startAt(new Date(System.currentTimeMillis() + 5000))
	    .forJob(job)
	    .withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?"))
			  .build();

    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);

    }
}