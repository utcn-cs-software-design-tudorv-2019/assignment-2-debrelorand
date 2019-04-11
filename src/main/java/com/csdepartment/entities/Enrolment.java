package com.csdepartment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import java.sql.Date;

@Entity
@Table(name="enrolment")
public class Enrolment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnrolment;
	
	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "courseid")
	private Course course;
	
	@Column(name = "startdate", nullable = false)
	private Date startDate;
	
	@Column(name = "finishdate", nullable = false)
	private Date finishDate;
	
	@Column(name = "int", nullable = false)
	private int nota;
	
	public Enrolment(int idEnrolment, Student student, Course course, Date startDate, Date finishDate, int nota) {
		super();
		this.idEnrolment = idEnrolment;
		this.student = student;
		this.course = course;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.nota = nota;
	}

	public int getIdEnrolment() {
		return idEnrolment;
	}

	public void setIdEnrolment(int idEnrolment) {
		this.idEnrolment = idEnrolment;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
}
