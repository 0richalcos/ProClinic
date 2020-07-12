package com.proclinic.demo.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proclinic.demo.entity.RoomDesc;
import com.proclinic.demo.repository.RoomDescRepository;
import com.proclinic.demo.service.RoomDescService;

@Service
public class RoomDescServiceImpl implements RoomDescService{

	@Autowired
	RoomDescRepository roomDescRepository;

	@Override
	public List<RoomDesc> findAll() {
		List<RoomDesc> roomList=roomDescRepository.findAll();
	
		return roomList;
	}


	

}
