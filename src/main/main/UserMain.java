package com.jspiders.springannotation.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.jspiders.springannotation.config.UserConfig;
import com.jspiders.springannotation.config.UserConfig2;
import com.jspiders.springannotation.entity.User;


public class UserMain {

	public static void main(String[] args) {
	ApplicationContext applicationContext=new AnnotationConfigApplicationContext(UserConfig.class);//inside the applicationContext container
															//user object store inside the applicationContext.
		User user=(User)applicationContext.getBean(User.class);//from the application we can get the object of user class by getBean()
															//getBean except the class OR the name.
		System.out.println(user);
		((AnnotationConfigApplicationContext)applicationContext).close();//annotationConfigApplicationContext it is an concrete class 
																		// which implement the applicationContext interface.
		
		ApplicationContext applicationContext2=new AnnotationConfigApplicationContext(UserConfig.class);
		User user2=(User) applicationContext2.getBean("user");
		System.out.println(user2);
		((AnnotationConfigApplicationContext)applicationContext2).close();
		
		ApplicationContext applicationContext3=new AnnotationConfigApplicationContext("com.jspiders.springannotation");
							//using the component we can create the bean we can pass the path of main package inside the main package
							//having all the classes in that classes which include @compomnent annotation then bean is created for that class.
		User user3=(User) applicationContext3.getBean("user");
		System.out.println(user3);
		((AnnotationConfigApplicationContext)applicationContext3).close();
		
		ApplicationContext applicationContext4=new AnnotationConfigApplicationContext(UserConfig2.class);
        User user4 =(User)applicationContext4.getBean("user");
        System.out.println(user4);
        ((AnnotationConfigApplicationContext)applicationContext4).close();
	}
	
}
