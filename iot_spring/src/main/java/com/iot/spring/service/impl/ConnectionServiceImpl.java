package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.common.dbcon.DBConnector;
import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	@Autowired
	private ConnectionDAO cdao;

	@Override
	public List<ConnectionInfoVO> getConnectionList(ConnectionInfoVO ci) {
		
		
		return cdao.selectConnectionList(ci);
	}

	@Override
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci) {
		
		return null;
	}

	@Override
	public void insertConnection(ConnectionInfoVO ci, Map<String, Object> rMap) {
		
		int result = cdao.insertConnection(ci);
		rMap.put("msg", "실패");
		if(result!=0) {
			rMap.put("msg", "성공");
		}			
	}
	

	@Override
	public List<Map<String, Object>> getDatabaseList(HttpSession hs, int ciNo) throws Exception{
		ConnectionInfoVO ci = cdao.selectConnection(ciNo);
		hs.setAttribute("ci", ci);
		DBConnector dbc = new DBConnector(ci);
		SqlSession ss = dbc.getSqlSession();
		hs.setAttribute("SqlSession", ss);		
		
		List<Map<String, Object>> dbList = cdao.selectDatabaseList(ss);
		
		int idx = 0;
		for(Map<String,Object> dbMap : dbList) {
			dbMap.put("id", ciNo + "_" + (++idx));
			dbMap.put("text", dbMap.get("Database"));	
			dbMap.put("items", new Object[] {});
		}		
		
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(HttpSession hs, String dbName) {
		SqlSession ss = (SqlSession) hs.getAttribute("SqlSession");
		return cdao.selectTableList(ss, dbName);
	}

	@Override
	public List<ColumnsVO> getColumnsList(Map<String, String> rMap) {
		
		return cdao.selectColumnsList(rMap);
	}

}
