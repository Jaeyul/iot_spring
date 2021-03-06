package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO{
	@Autowired
	@Qualifier("cmb")
	private SqlSessionFactory ssf;

	@Override
	public List<ConnectionInfoVO> selectConnectionList(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		List<ConnectionInfoVO> ConnectionList = ss.selectList("connection.selectConnectionInfo", ci);
		ss.close();
		return ConnectionList;
	}

	@Override
	public ConnectionInfoVO selectConnection(int ciNo) {
		
		SqlSession ss = ssf.openSession();
		ConnectionInfoVO ci = ss.selectOne("connection.selectConnectionInfoWithCiNo", ciNo);
		ss.close();
		return ci;
	}

	@Override
	public int insertConnection(ConnectionInfoVO ci) {
		int result = 0;
		SqlSession ss = ssf.openSession();
		result = ss.insert("connection.insertConnectionInfo", ci);
		ss.close();
		return result;
	}

	

	@Override
	public List<Map<String, Object>> selectDatabaseList(SqlSession ss) throws Exception {
		return ss.selectList("connection.selectDatabase");
	}

	@Override
	public List<TableVO> selectTableList(SqlSession ss, String dbName) {		
		List<TableVO> tableList = ss.selectList("connection.selectTable", dbName);
		
		return tableList;
	}

	@Override
	public List<ColumnsVO> selectColumnsList(Map<String, String> rMap) {
		SqlSession ss = ssf.openSession();
		List<ColumnsVO> ColumnList = ss.selectList("connection.selectColumns", rMap);		
		ss.close();
		return ColumnList;
	}

}
