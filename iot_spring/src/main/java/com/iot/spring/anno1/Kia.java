package com.iot.spring.anno1;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service("kkk")
@Order(value=1)
public class Kia implements Maker {
	
	public void printName() {
		
		System.out.println("기아차");
	}

}
