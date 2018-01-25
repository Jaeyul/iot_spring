package com.iot.spring.dev;

import org.springframework.stereotype.Component;

@Component("id")
public class Won {
	
	private int money;
	
	public Won() {
		System.out.println("원이 생성됨!");
		
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	

}
