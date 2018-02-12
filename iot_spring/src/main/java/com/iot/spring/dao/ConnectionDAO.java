package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

public interface ConnectionDAO {
	
	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci);
	public ConnectionInfoVO selectConnection(int ciNo);
	public int insertConnection(ConnectionInfoVO ci);
	
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception;
	public List<TableVO> selectTableList(SqlSession ss, String dbName);
	public List<ColumnsVO> selectColumnsList(Map<String,String> rMap);
	
}
