package com.iot.spring.anno1;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("aaa")
@Order(value=2)
public class Audi implements Maker{

	
	public void printName() {
		System.out.println("아우딬ㅋㅋ");
	}
	
	

}
