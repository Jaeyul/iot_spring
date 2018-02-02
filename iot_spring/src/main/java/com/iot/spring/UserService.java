package com.iot.spring;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	public List<User> getUserList(){
		User u = new User();
		u.setName("최재열");
		u.setAge(27);
		List<User> list = new ArrayList<User>();
		list.add(u);
		list.add(u);
		list.add(u);
		list.add(u);
		
		
		return list;
		
	}

}
