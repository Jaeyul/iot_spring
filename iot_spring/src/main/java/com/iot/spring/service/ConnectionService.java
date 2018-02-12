package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionService {
	
	public List<ConnectionInfoVO> getConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci);
	public void insertConnection(ConnectionInfoVO ci, Map<String, Object> rMap);
	
	public List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception;
	public List<TableVO> getTableList(HttpSession hs,String dbName);
	public List<ColumnsVO> getColumnsList(Map<String,String> rMap);
	
}
