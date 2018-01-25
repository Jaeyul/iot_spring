package com.iot.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iot.spring.dev.Worker;


public class Excute {
	private Worker w;
	
	public Excute(Worker w) {		
		this.w = w;		
	}
	
	public void setWorker(Worker w) {
		this.w = w;
		
	}
	
	public void printWorker() {
		w.goToWork();
		w.work();
		w.getOffWork();		
	}
	
	
	public static void main(String[] args) {
		
//		Resource res = new ClassPathResource("beans.xml");		
//		XmlBeanFactory bf = new XmlBeanFactory(res);  // 레이지 로딩 --> getBean에서 생성자가 생성됨
		ApplicationContext ac =new ClassPathXmlApplicationContext("beans2.xml");  // 프리로딩 --> getBean전에 생성자를 미리 다 만들어놓음
//		System.out.println("파싱 완료만 일까?");
//		Won w = (Won) ac.getBean("id");

		Excute ex = (Excute) ac.getBean("excute");
		ex.printWorker();
		
//		Car c = new Kia("소나타");
//		Money m = new Won();
//		m.setMoney(30000000);
//		c.setMoney(m);		
//		c.printCarInfo();		
		
		
		
		

		
	}

}
