package com.proclinic.demo.mapper;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.proclinic.demo.entity.Patient;

@Mapper
public interface PatientMapper {
	
	//增加一条病人记录
    @Insert("insert into patient(name,phone,address,gender,age,email,birthday) values(#{name},#{phone},#{address},#{gender},#{age},#{email},#{birthday})")
    public void add(Patient patient);

    //查出所有病人信息
    @Select("select * from patient")
    public List<Patient> show();
    
    //查询一个病人
    @Select("select * from patient where id=#{id}")
	public Patient findById(int id);

    //修改一个具体病人信息
    @Update("update patient SET "
    		+ "name=#{patient.name},"
    		+ "birthday=#{patient.birthday},"
    		+ "gender=#{patient.gender},"
    		+ "email=#{patient.email},"
    		+ "age=#{patient.age},"
    		+ "address=#{patient.address},"
    		+ "phone=#{patient.phone} where id=#{id}")
	public void updatepatient(@Param("patient")Patient patient,@Param("id") int id);
    
    //删除多条病人信息
    @Delete("delete from patient where id = #{id}")
    public void delete(int id);
    

}
