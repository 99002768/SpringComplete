package com.lt.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext("com");		
		GreetService greetService= context.getBean("greetServiceImpl",GreetService.class);
		System.out.print(greetService.greet("haii"));

	}

}
