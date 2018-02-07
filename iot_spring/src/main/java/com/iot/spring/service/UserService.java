package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserService {
	
	public List<UserInfo> getUserList();
	public UserInfo getUser(Map<String, String> map);
	public int insertEmp(UserInfo user);
	public int deleteEmp(Map<String, String> map);
	public int updateEmp(Map<String, String> map);

}
