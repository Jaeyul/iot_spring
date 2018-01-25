package com.iot.spring.dev;

public class Developer implements Worker {

	@Override
	public void goToWork() {
		System.out.println("개발자가 출근해용");

	}

	@Override
	public void work() {
		System.out.println("개발자가 일해용");
	}

	@Override
	public void getOffWork() {
		System.out.println("개발자가 퇴근해용");

	}

}
