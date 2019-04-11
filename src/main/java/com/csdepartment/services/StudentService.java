package com.csdepartment.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Course;
import com.csdepartment.entities.Student;
import com.csdepartment.repositories.StudentRepository;

@Service()
public class StudentService {

	@Inject
	StudentRepository studentRepository;

	public int registerStudent(Student student)
	{
		return studentRepository.save(student).getIdStudent();
	}
	
	public Student getByID(int id)
	{
		return studentRepository.findById(id);
	}
	
	public Student getByUsername(String username)
	{
		return studentRepository.findByUsername(username);
	}
	
	public boolean deleteStudent(Student student)
	{
		return studentRepository.deleteById(student.getIdStudent());
	}

}
