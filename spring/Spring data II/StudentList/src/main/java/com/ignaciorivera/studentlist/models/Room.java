package com.ignaciorivera.studentlist.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;



@Entity
@Table(name="rooms")
public class Room{
	    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
@Column(updatable=false)
private Date createdAt;
@OneToMany(mappedBy="room", fetch = FetchType.LAZY)
private List<Student> students;

public Room() {
	
}

public Room(String name, List<Student> students) {
	
	this.name = name;
	this.students=students;
	
}

@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}







}
