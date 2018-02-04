package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.Emp;

public interface EmpDAO {
	
	public List<Emp> selectEmpList();
	public Emp selectEmp(Map<String, String> map);
	public int insertEmp(Emp emp);
	public int deleteEmp(Map<String, String> map);
	public int updateEmp(Map<String, String> map);

}
