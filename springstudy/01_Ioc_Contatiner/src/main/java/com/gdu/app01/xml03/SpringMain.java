package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml03/appCtx.xml");
		Person myPerson = ctx.getBean("human", Person.class);
		
		System.out.println(myPerson.getName());
		System.out.println(myPerson.getAge());
		System.out.println(myPerson.getAddr().getJibun());;
		System.out.println(myPerson.getAddr().getRoad());;
		System.out.println(myPerson.getAddr().getZipCode());;
		
		ctx.close();
		
	}

}