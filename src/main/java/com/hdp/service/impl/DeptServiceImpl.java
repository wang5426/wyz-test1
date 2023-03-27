package com.hdp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdp.mapper.DeptMapper;
import com.hdp.pojo.Dept;
import com.hdp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper mapper;
	@Override
	public int insert(Dept obj) {
		try {
			return mapper.insert(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int delete(int id) {
		try {
			return mapper.delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int update(Dept obj) {
		// TODO Auto-generated method stub
		try {
			return mapper.update(obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Dept queryObject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int queryCount() {
		try {
			return mapper.queryCount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Dept> queryALL() {
		// TODO Auto-generated method stub
		try {
			return mapper.queryAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Dept> queryPage(int offset, int size) {
		try {
			Map<String,Integer> map = new HashMap<>();
			map.put("offset", offset);
			map.put("size", size);
			return mapper.queryPage(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int querySearchCount(String search) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Dept> querySearchPage(String search, int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
