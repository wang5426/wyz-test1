package com.hdp.service;

import java.util.List;

import com.hdp.pojo.Emp;
import com.hdp.pojo.Groups;

public interface GroupsService extends BaseService<Groups>{

	List<Emp> query_groups_emps(Integer groups);

	List<Emp> query_group_not_emps(Integer groups);

	int groups_emps_add(Integer groups, Integer emps);

	int groups_emps_del(Integer groups, Integer emps);

	int delete_groups(int id);
}
