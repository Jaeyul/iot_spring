package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService us;
	
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> getUserListAjax(Model m) {
		List<UserInfo> userList = us.getUserList();	
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("userList", userList);		
		userMap.put("msg", "성공!");
		return userMap;		
	}

}
