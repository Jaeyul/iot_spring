package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {
	
	public List<ConnectionInfoVO> selectConnectionList();
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci);
	public int insertConnection(ConnectionInfoVO ci);
	public List<Map<String, Object>> selectDatabaseList();
	public List<TableVO> selectTableList(String dbName);
	public List<ColumnsVO> selectColumnsList(Map<String,String> rMap);
	
}
