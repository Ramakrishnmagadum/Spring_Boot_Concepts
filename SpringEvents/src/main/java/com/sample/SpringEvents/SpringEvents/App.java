package com.sample.SpringEvents.SpringEvents;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.SpringEvents.config.AppConfig;
import com.sample.SpringEvents.publisher.ZeeCafePublisher;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        ZeeCafePublisher zeeCafePublisher= context.getBean("zeeCafePublisher" , ZeeCafePublisher.class);
        zeeCafePublisher.BigBangTheory(101);
    }
}
