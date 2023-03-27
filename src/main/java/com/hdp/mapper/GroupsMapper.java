package com.hdp.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hdp.pojo.Emp;
import com.hdp.pojo.Groups;

@Mapper
public interface GroupsMapper {
	
	@Select("select * from Groups")
	public List<Groups> queryAll() throws SQLException;
	
	@Select("select * from Groups where userName=#{userName} and password=#{password}")
	public Groups login(Groups obj) throws SQLException;

	@Update("update Groups set name=#{name},notes=#{notes} where id=#{id}")
	       //update userpwd    set password = ?                              where user_name = ?
	public int update(Groups obj) throws SQLException;

	@Insert("insert into Groups(userName,password) value(#{userName},#{password});")
	public int insert(Groups obj) throws SQLException;

	@Delete("delete from Groups where id =#{id};")
	public int delete(int id) throws SQLException;

	@Select("select count(*) as num  from Groups")
	public int queryCount()throws SQLException;

	@Select("select * from Groups order by id desc limit #{offset},#{size}")
	public List<Groups> queryPage(Map<String, Integer> map)throws SQLException;

	@Select("select * from emps e join groups_emps ge on ge.emps = e.id where ge.groups = #{groups}")
	public List<Emp> query_groups_emps(Integer groups) throws SQLException;

	@Select("select * from emps where id not in(select emps from groups_emps where groups = #{groups})")
	public List<Emp> query_groups_not_emps(Integer groups) throws SQLException;

	@Insert("insert into groups_emps(groups,emps) values(#{groups},#{emps})")
	public int groups_emps_add(Map<String, Object> map) throws SQLException;

	@Delete("delete from groups_emps where groups=#{groups} and emps=#{emps}")
	public int groups_emps_del(Map<String, Object> map) throws SQLException;

	@Delete("delete from groups_emps where groups=#{id}")
	public int delete_groups(int id) throws SQLException;
	
	
	
}
