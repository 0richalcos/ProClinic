package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proclinic.demo.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	@Query(nativeQuery = true,value="select*from department WHERE id=?1")
	Department findDepartmentByid(int id);

}
