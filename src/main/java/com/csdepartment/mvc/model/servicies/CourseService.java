package com.csdepartment.mvc.model.servicies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.mvc.model.entities.Course;
import com.csdepartment.mvc.model.repositories.CourseRepository;

@Service
public class CourseService {
	@Inject
	CourseRepository courseRepository;
	
	public Course makeCourse(Course course)
	{
		return courseRepository.save(course);
	}
	
	public List<Course> getAll()
	{
		return courseRepository.findAll();
	}
	
	public Course getById (int ID)
	{
		return courseRepository.findById(ID);
	}
	
	public List<Course> getByIdAdministrator(int ID)
	{
		List<Course> allCourse = courseRepository.findAll();
		List<Course> rezultat = new ArrayList<Course>();
		for(int i=0;i<allCourse.size();i++)
		{
			if (allCourse.get(i).getAdministrator().getId()==ID)
			{
				rezultat.add(allCourse.get(i));
			}
		}
		
		return rezultat;
	}
}
