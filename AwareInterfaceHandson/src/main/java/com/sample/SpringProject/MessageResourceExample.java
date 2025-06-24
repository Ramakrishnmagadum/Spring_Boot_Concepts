package com.sample.SpringProject;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MessageResourceExample implements MessageSourceAware {
	
	public MessageResourceExample() {
		super();
		System.out.println("MessageResourceExample constructer Initialized...");
	}

	public void setMessageSource(MessageSource messageSource) {
		System.out.println("#MessageResourceExample");
		String message = messageSource.getMessage("msg", null, Locale.US);
		System.out.println("Chosen Country gesture is : "+ message);
		String message2 = messageSource.getMessage("love", null, Locale.CHINA);
		System.out.println("About Coutry : "+ message2);
		System.out.println("\n");
	     
	}

}
