package com.proclinic.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

import com.proclinic.demo.entity.Department;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.entity.UserDesc;

@Mapper
public interface DoctorMapper {
	//查询医生信息
		@Select("select * from user_desc where id=#{id}")
		UserDesc DoctorInformation(int id);
		//修改医生信息
		@Update("update user_desc SET specialization=#{userdesc.specialization},experience=#{userdesc.experience},gender=#{userdesc.gender},birthday=#{userdesc.birthday},age=#{userdesc.age},details=#{userdesc.details},address=#{userdesc.address},phone=#{userdesc.phone},user_id=#{userdesc.user.id},department_id=#{userdesc.department.id} WHERE id=#{id}")
		void Doctorup(@Param("userdesc")UserDesc userdesc,@Param("id") int id);
		//查询医生管理员信息	
		@Select("select * from user where username=#{name}")
		User Doctorid(String name);
		//查询医生部门信息
		@Select("select * from department where name=#{department}")
		Department Doctordepartment(String department);
		//查询医生是否已存在
		@Select("select * from user_desc where user_id=#{id}")
		UserDesc doctorname(int id);
		//添加医生
		@Insert("INSERT INTO user_desc(specialization,experience,gender,birthday,age,details,address,phone,user_id,department_id) VALUES(#{specialization},#{experience},#{gender},#{birthday},#{age},#{details},#{address},#{phone},#{user.id},#{department.id})")
		void Doctoradd(UserDesc userdesc);
		//删除医生
		@Delete("delete from user_desc where id=#{id}")
		void Doctordelete(int id);
		//添加权限
		@Insert("insert into authorities(user_id,authority) values(#{id},#{authority})")
		void addqx(int id,String authority);
}
