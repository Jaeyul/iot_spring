package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {
	
	public List<ConnectionInfoVO> getConnectionList();
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci);
	public void insertConnection(ConnectionInfoVO ci, Map<String, Object> rMap);
	public List<Map<String, Object>> getDatabaseList();
	public List<TableVO> getTableList(String dbName);
	public List<ColumnsVO> getColumnsList(Map<String,String> rMap);
}
