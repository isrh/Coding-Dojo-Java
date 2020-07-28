package com.ignaciorivera.studentlist.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;



@Entity
@Table(name="subjects_students")
public class StudentSubject {

	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="student_id")
	 private Student student;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="subject_id")
	 private Subject subject;
	 
	 
	 public StudentSubject(Student student, Subject subject) {

		this.student = student;
		this.subject = subject;
	}
	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }
	 
}
