package com.hdp.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hdp.pojo.User;

@Mapper
public interface UserMapper {
	
	@Select("select * from users")
	public List<User> queryAll() throws SQLException;
	
	@Select("select * from users where userName=#{userName} and password=#{password}")
	public User login(User obj) throws SQLException;

	@Update("update users set userName=#{userName},password=#{password} where id=#{id}")
	       //update userpwd    set password = ?                              where user_name = ?
	public int update(User obj) throws SQLException;

	@Insert("insert into users(userName,password) value(#{userName},#{password});")
	public int insert(User obj) throws SQLException;

	@Delete("delete from users where id =#{id};")
	public int delete(int id) throws SQLException;

	@Select("select count(*) as num  from users")
	public int queryCount()throws SQLException;

	@Select("select * from users order by id desc limit #{offset},#{size}")
	public List<User> queryPage(Map<String, Integer> map)throws SQLException;
	
	
	
}
