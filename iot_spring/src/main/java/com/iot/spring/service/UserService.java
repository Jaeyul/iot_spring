package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

public interface UserService {
	
	public List<UserInfoVO> getUserList();
	
	public void insertUser(UserInfoVO ui, Map<String, Object> rMap);
	public void deleteUser(UserInfoVO ui, Map<String, Object> rMap);
	public void updateUser(UserInfoVO ui, Map<String, Object> rMap);
	public UserInfoVO getUserInfo(UserInfoVO ui);

}
