package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.UserInfo;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	@Qualifier("mb")
	private SqlSessionFactory ssf;

	@Override
	public List<UserInfo> selectUserList() {
		SqlSession ss = ssf.openSession();
		List<UserInfo> userList = ss.selectList("user.selectUser");
		ss.close();
		return userList;
		
	}


	@Override
	public UserInfo selectUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int insertEmp(UserInfo user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteEmp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateEmp(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}



}
