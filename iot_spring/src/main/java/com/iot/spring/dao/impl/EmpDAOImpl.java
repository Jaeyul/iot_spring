package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.vo.Emp;

@Repository
public class EmpDAOImpl implements EmpDAO{
	@Autowired
	@Qualifier("mb")
	private SqlSessionFactory ssf;
	

	@Override
	public List<Emp> selectEmpList() {
		SqlSession ss = ssf.openSession();
		List<Emp> empList = ss.selectList("emp.selectEmp");
		ss.close();
		return empList;
	}

	@Override
	public Emp selectEmp(Map<String, String> map) {
		SqlSession ss = ssf.openSession();
		Emp emp = ss.selectOne("emp.selectOneEmp", map);
		return emp;
	}

	@Override
	public int insertEmp(Emp emp) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("emp.insertEmp", emp);
		ss.close();
		return 0;
	}

	@Override
	public int deleteEmp(Map<String, String> map) {
		SqlSession ss = ssf.openSession();
		int result = ss.delete("emp.deleteEmp", map);
		ss.close();
		return result;
	}

	@Override
	public int updateEmp(Map<String, String> map) {
		SqlSession ss = ssf.openSession();
		int result = ss.update("emp.updateEmp", map);
		ss.close();
		return result;
	}

}
