package com.hdp.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hdp.pojo.Dept;

@Mapper
public interface DeptMapper {
	
	@Select("select * from depts")
	public List<Dept> queryAll() throws SQLException;
	
	@Select("select * from depts where userName=#{userName} and password=#{password}")
	public Dept login(Dept obj) throws SQLException;

	@Update("update depts set name=#{name},notes=#{notes} where id=#{id}")
	       //update userpwd    set password = ?                              where user_name = ?
	public int update(Dept obj) throws SQLException;

	@Insert("insert into depts(userName,password) value(#{userName},#{password});")
	public int insert(Dept obj) throws SQLException;

	@Delete("delete from depts where id =#{id};")
	public int delete(int id) throws SQLException;

	@Select("select count(*) as num  from depts")
	public int queryCount()throws SQLException;

	@Select("select * from depts order by id desc limit #{offset},#{size}")
	public List<Dept> queryPage(Map<String, Integer> map)throws SQLException;
	
	
	
}
