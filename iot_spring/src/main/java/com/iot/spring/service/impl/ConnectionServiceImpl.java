package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

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

}
