package com.proclinic.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proclinic.demo.entity.RoomDesc;

public interface RoomDescRepository extends JpaRepository<RoomDesc, Integer> {

	@Query(nativeQuery = true,value="SELECT name FROM room_desc r,room r1,USER u,user_desc u1,patient p "
+ "WHERE r.`room_id`=r1.`id` AND u.id=u1.`user_id` AND r.`user_id`=u.`id` "
+ "AND r.`patient_id`=p.`id` and r1.id=?1")
	List<RoomDesc> findAll(int id);
	@Query(nativeQuery = true,value=" SELECT *FROM room_desc  WHERE room_id=?1 AND patient_id=?2 ")
	RoomDesc findAlldescid(int id,int pid);
	
}
