package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.Emp;

public interface ConnectionDAO {
	
	public List<ConnectionInfoVO> selectConnectionList();
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci);
	public int insertConnection(ConnectionInfoVO ci);


}
