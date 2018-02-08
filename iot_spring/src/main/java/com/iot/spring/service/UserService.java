package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

public interface UserService {
	
	public List<UserInfoVO> getUserList();
	public UserInfo getUser(Map<String, String> map);
	public void insertUser(UserInfoVO ui, Map<String, Object> rMap);
	public int deleteEmp(Map<String, String> map);
	public int updateEmp(Map<String, String> map);

}
