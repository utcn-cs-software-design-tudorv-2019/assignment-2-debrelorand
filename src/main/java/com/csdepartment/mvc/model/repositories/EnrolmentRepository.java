package com.csdepartment.mvc.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.mvc.model.entities.Enrolment;

public interface EnrolmentRepository extends CrudRepository<Enrolment, Integer>{
	@SuppressWarnings("unchecked")
	public Enrolment save(Enrolment enrolment);
	public List<Enrolment> findAll();
	public Enrolment findById(int id);
	
}
