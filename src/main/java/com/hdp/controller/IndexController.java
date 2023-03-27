package com.hdp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hdp.pojo.User;
import com.hdp.service.UserService;

@Controller
public class IndexController {

	
	@Resource
	private UserService service;

	
	@RequestMapping("")
	public String index(HttpServletRequest request) {
		List<User> list = service.queryALL();
		request.setAttribute("list", list);
		return "index";
	}
}
