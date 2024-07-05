package com.jspiders.springannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.springannotation.config.PersonConfig;
import com.jspiders.springannotation.entity.Person;

public class PersonMain {

	
	public static void main(String[] args) {
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person=(Person)applicationContext.getBean("person");
		System.out.println(person);
		Person person2=(Person)applicationContext.getBean("person");
		System.out.println(person2);
		((AnnotationConfigApplicationContext)applicationContext).close();
		
		//one applicationContext contains same object. 
		//multiple applicationContext new object is created.
	}
}
