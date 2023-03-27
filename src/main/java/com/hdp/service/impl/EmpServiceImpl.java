package com.hdp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdp.mapper.EmpMapper;
import com.hdp.pojo.Emp;
import com.hdp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper mapper;
	@Override
	public int insert(Emp obj) {
		try {
			return mapper.insert(obj); //mapper 里面写sql语句，并将contrller里面返回的值给mapper
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
	public int update(Emp obj) {
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
	public Emp queryObject(int id) {
		// TODO Auto-generated method stub
		try {
			return mapper.queryObject(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
	public List<Emp> queryALL() {
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
	public List<Emp> queryPage(int offset, int size) {
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
	public List<Emp> querySearchPage(String search, int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
