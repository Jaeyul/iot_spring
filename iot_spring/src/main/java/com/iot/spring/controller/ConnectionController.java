package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnsVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;
import com.iot.spring.vo.UserInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	private static final Logger log = LoggerFactory.getLogger(ConnectionController.class);
	@Autowired
	private ObjectMapper om;
	
	@Autowired
	private ConnectionService cs;
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> ConnectionInsert(@RequestParam Map<String, Object> map) {
		ConnectionInfoVO ci = om.convertValue(map, ConnectionInfoVO.class); 
		log.info("ConnectionInfoVO => {}", ci);
		log.info("Map => {}", map);
		cs.insertConnection(ci, map);
		
		return map;
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getConnectionInfoList(@RequestParam Map<String, Object> map, HttpSession hs) {
		UserInfoVO ui = new UserInfoVO();
		if(hs.getAttribute("user")!=null) {
			ui = (UserInfoVO) hs.getAttribute("user");			
		}else {
			ui.setUiID("red");			
		}		
		ConnectionInfoVO ci = new ConnectionInfoVO();		
		ci.setUiID("red");		
		List<ConnectionInfoVO> ciList = cs.getConnectionList(ci);	
		map.put("list", ciList);			
		return map;
	}	
	
		
	@RequestMapping(value="/db_list/{ciNo}", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getDatabaseList(@PathVariable("ciNo") int ciNo, Map<String, Object> map, HttpSession hs) {
		List<Map<String, Object>> dbList;
		try {
			dbList = cs.getDatabaseList(hs, ciNo);
			map.put("list", dbList);
			map.put("parentId", ciNo);
		} catch (Exception e) {
			map.put("error", e.getMessage());
			log.error("db connection error => {}",e);		
		}
		return map;
	}	
	
	@RequestMapping(value="/tables/{dbName}/{parentId}", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getTableList(
			@PathVariable("dbName") String dbName,
			@PathVariable("parentId") String parentId,
			HttpSession hs,
			Map<String, Object> map) {
		
		log.info("dbName=>{},parentId=>{}", new Object[] {dbName,parentId});
		List<TableVO> tableList = cs.getTableList(hs, dbName);
		map.put("list", tableList);	
		map.put("parentId", parentId);
		return map;
	}	
	
	@RequestMapping(value="/columns/{dbName}/{tbName}", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> getColumnList(
			@PathVariable("dbName") String dbName,
			@PathVariable("tbName") String tbName,			
			@RequestParam Map<String, Object> map) {
		
		Map<String,String> pMap = new HashMap<String, String>();
		pMap.put("dbName", dbName);
		pMap.put("tbName", tbName);
		
		List<ColumnsVO> columnList = cs.getColumnsList(pMap);
		map.put("columnList",columnList);		
		return map;
	}	
	
	
}
