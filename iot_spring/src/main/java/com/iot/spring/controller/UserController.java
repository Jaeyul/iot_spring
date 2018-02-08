package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper om;
	
	@Autowired
	private UserService us;
	
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> getUserListAjax(Model m) {
		List<UserInfoVO> userList = us.getUserList();	
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("userList", userList);		
		userMap.put("msg", "성공!");
		return userMap;		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> ConnectionInsert(@RequestParam Map<String, Object> map) {
		UserInfoVO ui = om.convertValue(map, UserInfoVO.class); 
		log.info("UserInfoVO => {}", ui);
		log.info("Map => {}", map);
		us.insertUser(ui, map);
		
		return map;
	}
	

}
