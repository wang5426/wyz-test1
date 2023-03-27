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

@Mapper
public interface EmpMapper {
	
	@Select("select * from emps")
	public List<Emp> queryAll() throws SQLException;
	
	@Select("select * from emps where userName=#{userName} and password=#{password}")
	public Emp login(Emp obj) throws SQLException;

	@Update("update emps set dept = #{dept.id},name=#{name},sex=#{sex},phone=#{phone},email=#{email},address=#{address},idCard=#{idCard},weChat=#{weChat},notes=#{notes} where id=#{id}")
	       //update userpwd    set password = ?                              where user_name = ?
	public int update(Emp obj) throws SQLException;

	@Insert("insert into emps(name,sex,phone,email,address,idCard,weChat,notes,dept) value(#{name},#{sex},#{phone},#{email},#{address},#{idCard},#{weChat},#{notes},#{dept.id})")
	public int insert(Emp obj) throws SQLException;

	@Delete("delete from emps where id =#{id};")
	public int delete(int id) throws SQLException;

	@Select("select count(*) as num  from emps")
	public int queryCount()throws SQLException;

	@Select("select e.*,e.dept as `dept.id`,d.name as `dept.name` from emps e join depts d on d.id = e.dept order by id desc limit #{offset},#{size}")
	public List<Emp> queryPage(Map<String, Integer> map)throws SQLException;

	@Select("select e.*,e.dept as `dept.id` from emps e where id = #{id}")
	public Emp queryObject(int id) throws SQLException;
	
	
	
}
