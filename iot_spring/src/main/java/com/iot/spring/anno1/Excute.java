package com.iot.spring.anno1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Excute {
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("anno1/ioc.xml");
		Order o = (Order) ac.getBean("order");
		o.printMaker();
		o.printMList();
		
	}

}
