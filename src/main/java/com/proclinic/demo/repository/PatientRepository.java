package com.proclinic.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.entity.RoomDesc;


public interface PatientRepository extends JpaRepository<Patient,Integer> {

	@Query(nativeQuery = true,value="SELECT*FROM patient WHERE id IN (SELECT p.`id` FROM room_desc r,room r1,USER u,user_desc u1,patient p "
+ "WHERE r.`room_id`=r1.`id` AND u.id=u1.`user_id` AND r.`user_id`=u.`id` "
+ "AND r.`patient_id`=p.`id` and r1.id=?1)")
	List<Patient> findAllpname(int id);
}
