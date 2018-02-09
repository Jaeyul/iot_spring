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
	public UserInfoVO getUserInfo(UserInfoVO ui) {
		
		return udao.selectUser(ui);
	}
	
	private boolean isDuplUserInfo(UserInfoVO ui) {
		if(udao.checkUser(ui)!=0) {
			return true;			
		}
		return false;
	}
	
	@Override
	public void insertUser(UserInfoVO ui, Map<String, Object> rMap) {		
		int result = 0;		
		rMap.put("msg", "회원가입에 실패하였습니다.");
		if(isDuplUserInfo(ui)) {
			rMap.put("msg", ui.getUiID() + "는 이미 존재하는 아이디입니다.");
			return;
		}
		result = udao.insertUser(ui);
		if(result!=0) {
			rMap.put("msg", "회원가입에 성공하셨습니다.");
			rMap.put("signupOk", true);
		}	
	}

	@Override
	public void deleteUser(UserInfoVO ui, Map<String, Object> rMap) {
		int result = udao.insertUser(ui);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
	}

	@Override
	public void updateUser(UserInfoVO ui, Map<String, Object> rMap) {
		int result = udao.insertUser(ui);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
	}



	
	

}
