package com.proclinic.demo.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.proclinic.demo.entity.Patient;
import com.proclinic.demo.entity.Room;
import com.proclinic.demo.entity.RoomDesc;
import com.proclinic.demo.entity.User;
import com.proclinic.demo.repository.PatientRepository;
import com.proclinic.demo.repository.RoomDescRepository;
import com.proclinic.demo.repository.RoomRepository;
import com.proclinic.demo.repository.UserRepository;
import com.proclinic.demo.service.RoomDescService;
import com.proclinic.demo.service.Impl.PatientServiceImpl;
import com.proclinic.demo.service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/room")
public class RoomController {

	@Autowired
	RoomRepository roomRepository;
	@Autowired
	PatientServiceImpl patientServiceImpl;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	RoomDescRepository roomDescRepository; 
	@Autowired
	RoomDescService service;
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping("/{id}")//根据房间号码查询房间名称
	public String selid(@PathVariable int id) {
		Room r=roomRepository.findById(id).get();
		return r.getType() ;
	}
	@GetMapping("/selstatue/{id}")//根据房间号码查询房间状态
	public String selstatue(@PathVariable int id) {
		Room r=roomRepository.findById(id).get();
		return r.getStatus() ;
	}
	
	@GetMapping("/User/{uid}")//根据医生id查询名称
	public String seluid(@PathVariable int uid) {
		return userServiceImpl.selname(uid) ;
	}

	@GetMapping("/patient/{pid}")//根据病人id查询名字
	public String selpid(@PathVariable int pid) {
		Patient p=patientRepository.findById(pid).get();
		System.out.println(p.getName());
		return p.getName();
	}
	

	
	@PostMapping("/add")
	@ResponseBody//病房添加
	public int add(Integer id, Integer pid,String allotmentDate,String dischargeDate, Integer uid) throws ParseException {
		System.out.println(id+pid+ allotmentDate+dischargeDate+ uid);
	
		 int count=0;
	Room room=new Room();
	room.setId(id);
	Patient patient=new Patient();
	patient.setId(pid);
	User user=new User();
	user.setId(uid);
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(allotmentDate); 
	Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dischargeDate); 
  RoomDesc d= roomDescRepository.save
 (new RoomDesc(patient,user,room, date, date2));
  if(d!=null) {
	  count=1;
		Room room2=roomRepository.selrommcount(id);
		if(room2!=null) {
			room2.setStatus("已满");
			roomRepository.save(room2);
		}
	  
  }
		return count;
	}
	
	@GetMapping("/all")//查询病房
	public List<RoomDesc> all(){
		
		return service.findAll() ;
	}
	
	@GetMapping("/allpname/{id}")//查询病房的病人
	public List<Patient> allpname(@PathVariable int id){
		return patientServiceImpl.finallpname(id);
	}
	
	
	
	@GetMapping("/findAlldescid/{id}/{pid}")
	public RoomDesc findAlldescid(@PathVariable int id,@PathVariable int pid) {
		RoomDesc r=roomDescRepository.findAlldescid(id, pid);
		return r;
		
	}
	
	@GetMapping("/finddate/{id}/{pid}")
	public List<String> finddate(@PathVariable int id,@PathVariable int pid) {
		RoomDesc r=roomDescRepository.findAlldescid(id, pid);
		List<String> date =new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		date.add(sdf.format(r.getAllotmentDate()));
		date.add(sdf.format(r.getDischargeDate()));
		return date;
		
	}
	
	@DeleteMapping("/del/{id}")
	public void delid(@PathVariable int id) { 
		roomDescRepository.deleteById(id);
	}
	
	@PostMapping("/upd")
	@ResponseBody//修改病房详情
	public int upd(Integer id, Integer pid,String allotmentDate,String dischargeDate, Integer uid,Integer rid) throws ParseException {
		System.out.println(id+pid+ allotmentDate+dischargeDate+ uid);
		 int count=0;
	Room room=new Room();
	room.setId(id);
	Patient patient=new Patient();
	patient.setId(pid);
	User user=new User();
	user.setId(uid);
	Date date = new SimpleDateFormat("yyyy-MM-dd").parse(allotmentDate); 
	Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dischargeDate); 
     System.out.println(date);
  RoomDesc d= roomDescRepository.save
 (new RoomDesc(rid,patient,user,room, date, date2));
  if(d!=null) {
	  count=1;

  }
		return count;
	}
	
	
}
