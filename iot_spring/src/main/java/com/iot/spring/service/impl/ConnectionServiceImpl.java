package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ConnectionInfoVO> getConnectionList() {
		
		return cdao.selectConnectionList();
	}

	@Override
	public ConnectionInfoVO getConnection(ConnectionInfoVO ci) {
		
		return cdao.selectConnection(ci);
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
	public List<Map<String, Object>> getDatabaseList() {
		List<Map<String, Object>> dbList = cdao.selectDatabaseList();
		int idx = 0;
		for(Map<String,Object> dbMap : dbList) {
			dbMap.put("id", ++idx);
			dbMap.put("text", dbMap.get("Database"));	
			dbMap.put("items", new Object[] {});
		}		
		
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		
		return cdao.selectTableList(dbName);
	}

	@Override
	public List<ColumnsVO> getColumnsList(Map<String, String> rMap) {
		
		return cdao.selectColumnsList(rMap);
	}

}
