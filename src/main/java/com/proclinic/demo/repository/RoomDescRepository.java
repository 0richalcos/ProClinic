package com.proclinic.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proclinic.demo.entity.RoomDesc;

public interface RoomDescRepository extends JpaRepository<RoomDesc, Integer> {

	@Query(nativeQuery = true,value="SELECT  new com.johnfnash.learn.domain.ViewInfo(u,p,r) FROM room_desc r,room r1,USER u,user_desc u1,patient p" + 
			"WHERE r.`room_id`=r1.`id` AND u.id=u1.`user_id` AND r.`user_id`=u.`id` AND r.`patient_id`=p.`id`")
	List<RoomDesc> findAll(int id,int pid,String allotmentDate,String dischargeDate,int uid);
}
