package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.iot.spring.vo.Emp;



public interface EmpService {
	
	public List<Emp> getEmpList();
	public Emp getEmp();
	public int insertEmp(Emp emp);
	public int deleteEmp(Map<String, String> map);
	public int updateEmp(Map<String, String> map);
	
	
}
