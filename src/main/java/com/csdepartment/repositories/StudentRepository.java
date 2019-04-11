package com.csdepartment.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.entities.Student;

public interface StudentRepository extends CrudRepository<Student,Integer>{
	public Student save(Student student);
	public Student findById(int id);
	public Student findByUsername(String username);
	public List<Student> findAll();
	public boolean deleteById(int ID);
}
