package com.ignaciorivera.studentlist.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;




@Entity
@Table(name="students")
public class Student {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String firstName;
 private String lastName;
 private int age;
 
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
 private Contact contact;
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="room_id")
 private Room room;
 
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "subjects_students", 
     joinColumns = @JoinColumn(name = "student_id"), 
     inverseJoinColumns = @JoinColumn(name = "subject_id")
 )
 private List<Subject> subjects;
public Student() {
	
}


public Student(String firstName, String lastName, int age) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	
}

@PrePersist
protected void onCreate(){
    this.createdAt = new Date();
}
@PreUpdate
protected void onUpdate(){
    this.updatedAt = new Date();
}


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public Date getCreatedAt() {
	return createdAt;
}


public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}


public Date getUpdatedAt() {
	return updatedAt;
}


public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}


public Contact getContact() {
	return contact;
}


public void setContact(Contact contact) {
	this.contact = contact;
}


public Room getRoom() {
	return room;
}


public void setRoom(Room room) {
	this.room = room;
}


public List<Subject> getSubjects() {
	return subjects;
}


public void setSubjects(List<Subject> subjects) {
	this.subjects = subjects;
}



 

 
 

}
