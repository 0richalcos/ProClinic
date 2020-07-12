package com.proclinic.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proclinic.demo.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {
	@Query(nativeQuery = true,value=" SELECT *FROM room WHERE id=?1 AND size=(SELECT COUNT(*) FROM room r,room_desc r1 WHERE r1.`room_id`=r.`id` AND r.id=?1)")
	Room selrommcount(int id);
	

}
