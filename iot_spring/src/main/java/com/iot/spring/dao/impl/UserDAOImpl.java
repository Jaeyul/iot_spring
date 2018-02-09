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
	public UserInfoVO selectUser(UserInfoVO ui) {
		SqlSession ss = ssf.openSession();
		UserInfoVO uiv = ss.selectOne("user.selectUser", ui);
		return uiv;
	}


	@Override
	public int insertUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.insert("user.insertUser", ui);
		return result;
	}

	@Override
	public int deleteUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.delete("user.updateUser", ui);
		return result;
	}

	@Override
	public int updateUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.update("user.updateUser", ui);
		return result;
	}

	@Override
	public int checkUser(UserInfoVO ui) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.selectOne("user.checkUser", ui);
		return result;
	}









}
