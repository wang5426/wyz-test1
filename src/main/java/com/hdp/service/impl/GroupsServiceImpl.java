package com.hdp.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdp.mapper.GroupsMapper;
import com.hdp.pojo.Emp;
import com.hdp.pojo.Groups;
import com.hdp.service.GroupsService;
import com.hdp.service.GroupsService;

@Service
public class GroupsServiceImpl implements GroupsService {

	@Autowired
	private GroupsMapper mapper;
	@Override
	public int insert(Groups obj) {
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
	public int update(Groups obj) {
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
	public Groups queryObject(int id) {
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
	public List<Groups> queryALL() {
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
	public List<Groups> queryPage(int offset, int size) {
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
	public List<Groups> querySearchPage(String search, int offset, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> query_groups_emps(Integer groups) {
		// TODO Auto-generated method stub
		try {
			return mapper.query_groups_emps(groups);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Emp> query_group_not_emps(Integer groups) {
		// TODO Auto-generated method stub
		try {
			return mapper.query_groups_not_emps(groups);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int groups_emps_add(Integer groups, Integer emps) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("groups", groups);
		map.put("emps", emps);
		try {
			return mapper.groups_emps_add(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int groups_emps_del(Integer groups, Integer emps) {
		Map<String,Object> map = new HashMap<>();
		map.put("groups", groups);
		map.put("emps", emps);
		try {
			return mapper.groups_emps_del(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete_groups(int id) {
		// TODO Auto-generated method stub
		try {
			return mapper.delete_groups(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

}
