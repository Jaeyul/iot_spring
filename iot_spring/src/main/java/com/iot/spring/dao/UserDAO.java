package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserInfo;
import com.iot.spring.vo.UserInfoVO;

public interface UserDAO {
	
	public List<UserInfoVO> selectUserList();
	public UserInfo selectUser(Map<String, String> map);
	public int insertUser(UserInfoVO ui);
	public int deleteUser(Map<String, String> map);
	public int updateUser(Map<String, String> map);

}
