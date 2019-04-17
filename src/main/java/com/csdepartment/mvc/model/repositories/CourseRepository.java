package com.csdepartment.mvc.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.mvc.model.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	@SuppressWarnings("unchecked")
	public Course save(Course course);
	public List<Course> findAll();
	public void deleteById(int ID);
	public Course findById(int ID);
}
