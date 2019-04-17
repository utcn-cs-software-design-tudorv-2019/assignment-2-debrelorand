package com.csdepartment.mvc.model.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="enrolment")
public class Enrolment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idenrolment;
	
	@ManyToOne
	@JoinColumn(name = "idstudent")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "idcourse")
	private Course course;
	
	@Column(name = "startdate", nullable = false)
	private Date startdate;
	
	@Column(name = "finishdate", nullable = false)
	private Date finishdate;
	
	@Column(name = "nota", nullable = false)
	private int nota;
	
	public Enrolment()
	{
		super();
	}
	
	public Enrolment(Student student, Course course, Date startDate, Date finishDate, int nota) {
		super();
		this.student = student;
		this.course = course;
		this.startdate = startDate;
		this.finishdate = finishDate;
		this.nota = nota;
	}

	public int getIdEnrolment() {
		return idenrolment;
	}

	public void setIdEnrolment(int idEnrolment) {
		this.idenrolment = idEnrolment;
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
		return startdate;
	}

	public void setStartDate(Date startDate) {
		this.startdate = startDate;
	}

	public Date getFinishDate() {
		return finishdate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishdate = finishDate;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Enrolment [idenrolment=" + idenrolment + ", student=" + student.getNume() + ", course=" + course.getNume() + ", startdate="
				+ startdate + ", finishdate=" + finishdate + ", nota=" + nota + "]";
	}
	
	
}
