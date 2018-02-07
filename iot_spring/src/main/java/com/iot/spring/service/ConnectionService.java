package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionService {
	
	public List<ConnectionInfoVO> getConnectionList();
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci);
	public void insertConnection(ConnectionInfoVO ci, Map<String, Object> rMap);

}
