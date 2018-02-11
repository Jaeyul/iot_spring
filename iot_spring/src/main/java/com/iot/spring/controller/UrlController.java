package com.iot.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UrlController {	
	
	@Autowired
	@Qualifier("mb")
	private SqlSessionFactory ssf;

	private static final Logger logger = LoggerFactory.getLogger(UrlController.class);
	
	private String getUri(String uri, String rootPath) {			
		return  uri.replace(rootPath + "/path", "");			
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("title","IOT-SPRING-2");
		return "index";
	}		
	
	@RequestMapping("/path/**")
	public String forwardJsp(HttpServletRequest request, Model model) {			
		
		String uri = request.getRequestURI();
		String rootPath = request.getContextPath();
		uri = getUri(uri, rootPath);		
		logger.info("path =>{}", uri);			
		return uri;
	}
	
	
	

}
