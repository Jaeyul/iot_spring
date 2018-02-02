package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService es;
	
	@RequestMapping(value= "/list", method = RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		
		
		m.addAttribute("empList", empList);
		
		return "emp/jstl_list";
		
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)	
	public String insertEmp(			
			@Valid Emp empDTO, Errors er,
			Model m) {
		
		if(er.hasErrors()) {
			logger.info("error => {}", er);
			m.addAttribute("errorMsg",er.getAllErrors());
			return "error/error";			
		}
		logger.info("insert result => {}", empDTO);
		es.insertEmp(empDTO);
		
		return "emp/write";		
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.GET)	
	public String deleteEmp(			
			@RequestParam Map<String, String> map,
			Model m) {
		
		logger.info("mpa=>{}", map);	
		
		m.addAttribute("msg", "실패했슴");		
		int result = es.deleteEmp(map);			
		if(result != 0) {
			m.addAttribute("msg", "올 성공ㅋ");			
		}
		
		return "emp/write";		
	}
	
	@RequestMapping(value="/update", method = RequestMethod.GET)	
	public String updateEmp(			
			@RequestParam Map<String, String> map,
			Model m) {
		
		logger.info("mpa=>{}", map);		
		m.addAttribute("msg", "실패했슴");		
		int result = es.updateEmp(map);			
		if(result != 0) {
			m.addAttribute("msg", "올 성공ㅋ");			
		}
		
		return "emp/write";		
	}
	
	
	
	

}
