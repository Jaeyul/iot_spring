package com.iot.spring.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ObjectMapper om;
	
	@Autowired
	private UserService us;
	
	
	@RequestMapping(value= "/lista", method = RequestMethod.GET)
	public @ResponseBody Map<String,Object> getUserListAjax(Model m) {
		List<UserInfoVO> userList = us.getUserList();	
		Map<String,Object> userMap = new HashMap<String,Object>();
		userMap.put("userList", userList);		
		userMap.put("msg", "성공!");
		return userMap;		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> UserInsert(@RequestParam Map<String, Object> map) {
		UserInfoVO ui = om.convertValue(map, UserInfoVO.class); 
		log.info("UserInfoVO => {}", ui);
		log.info("Map => {}", map);
		us.insertUser(ui, map);
		
		return map;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> UserDelete(@RequestParam Map<String, Object> map) {
		UserInfoVO ui = om.convertValue(map, UserInfoVO.class); 
		log.info("UserInfoVO => {}", ui);
		log.info("Map => {}", map);
		us.deleteUser(ui, map);
		
		return map;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> UserUpdate(@RequestParam Map<String, Object> map) {
		UserInfoVO ui = om.convertValue(map, UserInfoVO.class); 
		log.info("UserInfoVO => {}", ui);
		log.info("Map => {}", map);
		us.updateUser(ui, map);
		
		return map;
	}
	
	@RequestMapping(value="/login")
	public @ResponseBody Map<String, Object> login(@Valid UserInfoVO ui, HttpSession hs){
//		log.info("Before Login HttpSession => {}", hs.getAttribute("user"));		
//		hs.setAttribute("user", ui);
//		hs.setAttribute("isLogin", true);
//		log.info("After Login HttpSession => {}", hs.getAttribute("user"));		
		Map<String,Object> map = new HashMap<String,Object>();
		ui=us.getUserInfo(ui);		
		log.info("us.getUserInfo(ui) => {}", ui);
		map.put("loginOk", false);
		map.put("msg","로그인실패");
		if(ui!=null) {
			map.put("loginOk", true);
			map.put("msg","로그인성공");
			
			hs.setAttribute("user", ui);
			hs.setAttribute("isLogin", true);
		}		
		return map;
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession hs){
//		log.info("Before Login HttpSession => {}", hs.getAttribute("user"));		
//		hs.setAttribute("user", ui);
//		hs.setAttribute("isLogin", true);
//		log.info("After Login HttpSession => {}", hs.getAttribute("user"));		
		hs.removeAttribute("user");	
		hs.removeAttribute("isLogin");	
		return "index";
	}
	
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> signup(@Valid UserInfoVO ui, HttpSession hs){
//	
		Map<String,Object> map = new HashMap<String,Object>();
		us.insertUser(ui, map);
		
		return map;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody List<UserInfoVO> getUserList(){		
		
		return us.getUserList();
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getView(@Valid UserInfoVO ui, Errors er, ModelAndView model) throws JsonGenerationException, JsonMappingException, IOException {
		ui = us.getUserInfo(ui);
		String json = om.writeValueAsString(ui);				
		model.setViewName("/user/view");
		model.addObject("ui", ui);
		return model;
	}	
	
	
	

}
