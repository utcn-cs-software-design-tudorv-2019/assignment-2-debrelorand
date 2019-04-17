package com.csdepartment.mvc.model.servicies;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.mvc.model.entities.Student;
import com.csdepartment.mvc.model.repositories.StudentRepository;

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
		studentRepository.deleteById(student.getIdStudent());
		Student studentt = studentRepository.findById(student.getIdStudent());
		if (studentt==null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Student update(Student student)
	{
		return studentRepository.save(student);
	}
	
	public List<Student> getAll()
	{
		return studentRepository.findAll();
	}

}
