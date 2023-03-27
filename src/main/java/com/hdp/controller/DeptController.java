package com.hdp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdp.pojo.Dept;
import com.hdp.service.DeptService;
import com.hdp.utils.ResponeseCode;
import com.hdp.utils.ResponseEntity;

@RestController
@RequestMapping("dept")
public class DeptController {
	
	@Resource
	private DeptService service;
	
	@RequestMapping("list")
	public Map<String,Object> list(Integer page){
		int size = 10;
		int currentPage = page;
		int offset = (page-1)*size;
		int count = service.queryCount();
		int totalPage = (count+size-1)/size;
		List<Dept> list =service.queryPage(offset, size);
		Map<String,Object>map = new HashMap<>();
		map.put("list", list);
		map.put("total", count);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		
		return map;
	}
	
	@RequestMapping("list_all")
	public List<Dept> list_all(){
		return service.queryALL();
	}
	
	@RequestMapping("edit")
	public ResponseEntity edit(Dept obj) {
		int i = service.update(obj);
		return ResponseEntity.success();
	}
	@RequestMapping("add")
	public ResponseEntity add(Dept obj) {
		int i = service.insert(obj);
		return ResponseEntity.success();
	}
	
	@RequestMapping("delete")
	public ResponseEntity delete(int id) {
		int i = service.delete(id);
		return ResponseEntity.success();
	}
	
	
	@RequestMapping("exit")
	public ResponseEntity exit(HttpSession session) {
		session.invalidate();
		return ResponseEntity.success();
	}
}
