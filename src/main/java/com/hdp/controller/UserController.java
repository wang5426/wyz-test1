package com.hdp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hdp.pojo.User;
import com.hdp.service.UserService;
import com.hdp.utils.ResponeseCode;
import com.hdp.utils.ResponseEntity;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Resource
	private UserService service;
	
	@RequestMapping("list")
	public Map<String,Object> list(Integer page){
		int size = 10;
		int currentPage = page;
		int offset = (page-1)*size;
		int count = service.queryCount();
		int totalPage = (count+size-1)/size;
		List<User> list =service.queryPage(offset, size);
		Map<String,Object>map = new HashMap<>();
		map.put("list", list);
		map.put("total", count);
		map.put("currentPage", currentPage);
		map.put("totalPage", totalPage);
		
		return map;
	}
	
	@RequestMapping("login")
	public ResponseEntity login(HttpSession session,User obj) {
		User user = service.login(obj); //登录界面传过来的用户密码数值是否与数据库完全相等,不相等user == null
		if(user != null) {
			session.setAttribute("user", user);
			return ResponseEntity.success(ResponeseCode.STATUS_OK);
		}else {
			System.out.println("login");
			return ResponseEntity.success(200,ResponeseCode.STATUS_NO);
			
		}
	}
	
	@RequestMapping("edit")
	public ResponseEntity edit(User obj) {
		int i = service.update(obj);
		return ResponseEntity.success();
	}
	@RequestMapping("add")
	public ResponseEntity add(User obj) {
		int i = service.insert(obj);
		return ResponseEntity.success();
	}
	
	@RequestMapping("delete")
	public ResponseEntity delete(int id) {
		int i = service.delete(id);
		return ResponseEntity.success();
	}
	
	@RequestMapping("isLogin")
	public ResponseEntity isLogin(HttpSession session) {
		Object obj =session.getAttribute("user");
		if(obj == null) {
			return ResponseEntity.success(ResponeseCode.STATUS_NO);
		}else {
			List<User> list =service.queryALL();
			return ResponseEntity.success(ResponeseCode.STATUS_YES,list);
		}
	}
	@RequestMapping("exit")
	public ResponseEntity exit(HttpSession session) {
		session.invalidate();
		return ResponseEntity.success();
	}
	
	@RequestMapping("test")       //网页跳转
	@ResponseBody
	public ModelAndView test() {
		ModelAndView view = new ModelAndView("/test");
		return view;
	}
}
