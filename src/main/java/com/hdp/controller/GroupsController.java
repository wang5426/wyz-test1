package com.hdp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdp.pojo.Emp;
import com.hdp.pojo.Groups;
import com.hdp.service.GroupsService;
import com.hdp.utils.ResponeseCode;
import com.hdp.utils.ResponseEntity;

@RestController
@RequestMapping("groups")
public class GroupsController {
	
	@Resource
	private GroupsService service;
	
	@RequestMapping("list")
	public Map<String,Object> list(Integer page){
		int size = 10;
		int currentPage = page;
		int offset = (page-1)*size;
		int count = service.queryCount();
		int totalPage = (count+size-1)/size;
		List<Groups> list =service.queryPage(offset, size);
		Map<String,Object>map = new HashMap<>();
		map.put("list", list);
		map.put("total", count);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		
		return map;
	}
	
	@RequestMapping("list_all")
	public List<Groups> list_all(){
		return service.queryALL();
	}
	
	@RequestMapping("edit")
	public ResponseEntity edit(Groups obj) {
		int i = service.update(obj);
		return ResponseEntity.success();
	}
	@RequestMapping("add")
	public ResponseEntity add(Groups obj) {
		int i = service.insert(obj);
		return ResponseEntity.success();
	}
	
	@RequestMapping("isDelete")
	public ResponseEntity isDelete() {
		return ResponseEntity.success();
	}
	@RequestMapping("delete")
	public ResponseEntity delete(int id) {
		int j = service.delete_groups(id);
		int i = service.delete(id);
		return ResponseEntity.success();
	}
	
	
	@RequestMapping("exit")
	public ResponseEntity exit(HttpSession session) {
		session.invalidate();
		return ResponseEntity.success();
	}
	
	@RequestMapping("groups_emps_list")
	public Map<String,Object> groups_emps_list(Integer groups){
		Map<String,Object> map = new HashMap<>();
		List<Emp> emps = service.query_groups_emps(groups);
		List<Emp> not_emps = service.query_group_not_emps(groups);
		map.put("emps", emps);
		map.put("not_emps", not_emps);
		return map;
	}
	
	@RequestMapping("groups_emps_add")
	public ResponseEntity groups_emps_add(Integer groups,Integer emps) {
		int i = service.groups_emps_add(groups,emps);
		return ResponseEntity.success();
	}
	
	@RequestMapping("groups_emps_del")
	public ResponseEntity groups_emps_del(Integer groups,Integer emps) {
		int i = service.groups_emps_del(groups,emps);
		return ResponseEntity.success();
	}
	
}
