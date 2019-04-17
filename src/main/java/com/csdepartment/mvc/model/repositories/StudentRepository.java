package com.csdepartment.mvc.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.mvc.model.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>{
	@SuppressWarnings("unchecked")
	public Student save(Student student);
	public Student findById(int id);
	public Student findByUsername(String username);
	public List<Student> findAll();
	public void deleteById(int ID);
}
