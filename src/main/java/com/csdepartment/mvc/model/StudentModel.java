package com.csdepartment.mvc.model;

import com.csdepartment.mvc.model.entities.Student;

public class StudentModel {
	
	private  Student student;
	
	public StudentModel() {
		this.student = new Student();
	}
	
	public StudentModel(Student student)
	{
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
