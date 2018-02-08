package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

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
	public List<ConnectionInfoVO> selectConnectionList() {
		SqlSession ss = ssf.openSession();
		List<ConnectionInfoVO> ConnectionList = ss.selectList("connection.selectConnectionInfo");
		ss.close();
		return ConnectionList;
	}

	@Override
	public ConnectionInfoVO selectConnection(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		ConnectionInfoVO civ = ss.selectOne("connection.selectConnectionInfoOne", ci);
		return civ;
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
	public List<Map<String, Object>> selectDatabaseList() {
		SqlSession ss = ssf.openSession();
		List<Map<String, Object>> databaseList = ss.selectList("connection.selectDatabase");
		ss.close();
		return databaseList;
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {
		SqlSession ss = ssf.openSession();
		List<TableVO> tableList = ss.selectList("connection.selectTable", dbName);
		ss.close();
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
