package com.iot.spring.anno1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Order {
	@Autowired
	@Qualifier("kkk")
	private Maker m;
	 
	@Autowired	
	private List<Maker> mList;
	
	public void printMaker() {
		m.printName();	
	}
	
	public void printMList() {
		for(Maker m : mList) {
			m.printName();			
		}		
	}
	
	
	
}
