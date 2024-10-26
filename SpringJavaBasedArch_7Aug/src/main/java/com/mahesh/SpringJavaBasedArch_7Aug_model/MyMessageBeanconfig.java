package com.mahesh.SpringJavaBasedArch_7Aug_model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyMessageBeanconfig {
	
	@Bean
   public Mymessage Mymethod() {
	   return new Mymessage();
   }
}
