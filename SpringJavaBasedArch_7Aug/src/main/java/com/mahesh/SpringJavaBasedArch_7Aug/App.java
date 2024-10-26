package com.mahesh.SpringJavaBasedArch_7Aug;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.ApplicationContext;
import com.mahesh.SpringJavaBasedArch_7Aug_model.Mymessage;

public class App 
{
    public static  void main( String[] args )
    {
    ApplicationContext context=new AnnotationConfigApplicationContext(Mymessage.class);
    Mymessage mymessage=context.getBean(Mymessage.class);
    mymessage.setMessage("Welcome to the world of Spring Beans-java based configuration");
    mymessage.getMessage();
    ((AbstractApplicationContext)context).close();
    }
}
