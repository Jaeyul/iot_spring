package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO{
	@Autowired
	@Qualifier("mb")
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

}
