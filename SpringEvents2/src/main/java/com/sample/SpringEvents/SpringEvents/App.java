package com.sample.SpringEvents.SpringEvents;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.SpringEvents.config.AppConfig;
import com.sample.SpringEvents.publisher.Gpay;

public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Gpay gpay= context.getBean("gpay" , Gpay.class);
        
        context.start();//# This will trigger the "ContextStartEvent" ......
        gpay.sendMoney("ram", "100.00", true);
   
        context.stop(); //# This will trigger the "ContextStoppedEvent" ......
        context.close();//# This will trigger the "ContextClosedEvent" ......
    }
}
