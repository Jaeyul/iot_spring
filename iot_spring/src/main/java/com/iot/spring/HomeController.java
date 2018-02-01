package com.iot.spring;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/h", method = RequestMethod.GET)
	@ResponseBody
	public String home1(Locale locale, Model model) {
		model.addAttribute("test","난 테스트입니다.");
		model.addAttribute("text","난 텍스트입니다.");
		return "home1";
	}
	
	@RequestMapping(value = "/h2", method = RequestMethod.GET)
	
	public @ResponseBody List<User> home2() {
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
