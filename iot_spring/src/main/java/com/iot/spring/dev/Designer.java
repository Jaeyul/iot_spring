package com.iot.spring.dev;

public class Designer implements Worker {

	@Override
	public void goToWork() {
		System.out.println("디자이너가 출근해용");

	}

	@Override
	public void work() {
		System.out.println("디자이너가 일해용");

	}

	@Override
	public void getOffWork() {
		System.out.println("디자이너가 퇴근해용");

	}

}
