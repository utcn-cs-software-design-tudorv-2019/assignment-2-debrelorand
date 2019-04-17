package com.csdepartment.mvc.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcourse",nullable=false)
	private int idcourse;
	
	@ManyToOne
	@JoinColumn(name = "idadministrator")
	private Administrator administrator;
	
	@Column(name = "nume", nullable = false)
	private String nume;
	
	@Column(name = "credit", nullable = false)
	private int credit;
	
	public Course()
	{
		super();
	}
	
	public Course(Administrator administrator, String nume, int credit) {
		super();
		this.administrator = administrator;
		this.nume = nume;
		this.credit = credit;
	}

	public int getIdCourse() {
		return idcourse;
	}

	public void setIdCourse(int idCourse) {
		this.idcourse = idCourse;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [idcourse=" + idcourse + ", administrator=" + administrator + ", nume=" + nume + ", credit="
				+ credit + "]";
	}
}