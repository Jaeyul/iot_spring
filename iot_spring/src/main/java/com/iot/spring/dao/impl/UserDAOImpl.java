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
import com.iot.spring.vo.UserInfoVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	@Qualifier("cmb")
	private SqlSessionFactory ssf;

	@Override
	public List<UserInfoVO> selectUserList() {
		SqlSession ss = ssf.openSession();
		List<UserInfoVO> userList = ss.selectList("user.selectUser");
		ss.close();
		return userList;
		
	}

	@Override
	public UserInfo selectUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.insert("user.insertUser", ui);
		return result;
	}

	@Override
	public int deleteUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}





}
