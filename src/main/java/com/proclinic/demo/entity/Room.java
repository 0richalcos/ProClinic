package com.proclinic.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type", length = 10)
    private String type;

    @Column(name = "size", length = 4)
    private int size;

    @Column(name = "status", length = 10)
    private String status = "未满";

    @OneToMany
    @JoinColumn(name = "room_id")
    @JsonIgnore
    private List<RoomDesc> roomDescs;

    public Room() {
		// TODO Auto-generated constructor stub
	}
    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    public int getSize() {
	return size;
    }

    public void setSize(int size) {
	this.size = size;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }

    public List<RoomDesc> getRoomDescs() {
	return roomDescs;
    }

    public void setRoomDescs(List<RoomDesc> roomDescs) {
	this.roomDescs = roomDescs;
    }

}
