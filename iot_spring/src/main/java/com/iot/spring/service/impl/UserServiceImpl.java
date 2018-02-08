package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO udao;
	

	@Override
	public List<UserInfoVO> getUserList() {
		
		return udao.selectUserList();
	}

	@Override
	public UserInfo getUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertUser(UserInfoVO ui, Map<String, Object> rMap) {
		
		int result = udao.insertUser(ui);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
		
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
