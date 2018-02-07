package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;

public interface UserDAO {
	
	public List<UserInfo> selectUserList();
	public UserInfo selectUser(Map<String, String> map);
	public int insertEmp(UserInfo user);
	public int deleteEmp(Map<String, String> map);
	public int updateEmp(Map<String, String> map);

}
