package com.proclinic.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.entity.UserDesc;

@Mapper
public interface DoctorMapper {
	//查询医生信息
	@Select("select * from user_desc where id=#{id}")
	UserDesc DoctorInformation(int id);
	//修改医生信息
	@Update("UPDATE user_desc SET specialization=#{specialization},experience=#{experience},gender=#{gender},birthday=#{birthday},age=#{age},email=#{email},details=#{details},address=#{address},phone=#{phone},user_id=#{user.id},department_id=#{department.id} WHERE id=#{id}")
	void Doctorup(UserDesc userdesc);
	//查询医生管理员信息	
	@Select("select * from user where name=#{name}")
	User Doctorid(String name);
	//查询医生部门信息
	@Select("select * from department where name=#{department}")
	Department Doctordepartment(String department);
	//添加医生
	@Insert("INSERT INTO user_desc(specialization,experience,gender,birthday,age,email,details,address,phone,user_id,department_id) VALUES(#{specialization},#{experience},#{gender},#{birthday},#{age},#{email},#{details},#{address},#{phone},#{user_id},#{department_id})")
	void Doctoradd(UserDesc userdesc);
	//删除医生
	@Delete("delete from user_desc where id=#{id}")
	void Doctordelete(int id);
}
