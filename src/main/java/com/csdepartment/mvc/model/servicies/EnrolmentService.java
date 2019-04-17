package com.csdepartment.mvc.model.servicies;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.mvc.model.entities.Enrolment;
import com.csdepartment.mvc.model.repositories.EnrolmentRepository;

@Service
public class EnrolmentService {
	@Inject
	EnrolmentRepository enrolmentRepository;
	
	public Enrolment makeEnrolment(Enrolment enrolment)
	{
		return enrolmentRepository.save(enrolment);
	}
	
	public List<Enrolment> getAll()
	{
		return enrolmentRepository.findAll();
	}
	
	public List<Enrolment> getAllByIdStudent(int ID)
	{
		List<Enrolment> allEnrolment = enrolmentRepository.findAll();
		List<Enrolment> rezultat = new ArrayList<Enrolment> ();
		for(int i=0;i<allEnrolment.size();i++)
		{
			if(allEnrolment.get(i).getStudent().getIdStudent()==ID)
			{
				rezultat.add(allEnrolment.get(i));
			}
		}
		return rezultat;
	}
	
	public List<Enrolment> getAllByIdCourse(int ID)
	{
		List<Enrolment> allEnrolment = enrolmentRepository.findAll();
		List<Enrolment> rezultat = new ArrayList<Enrolment> ();
		for(int i=0;i<allEnrolment.size();i++)
		{
			if(allEnrolment.get(i).getCourse().getIdCourse()==ID)
			{
				rezultat.add(allEnrolment.get(i));
			}
		}
		return rezultat;
	}
	
	public Enrolment getByIdEnrolment(int ID)
	{
		return enrolmentRepository.findById(ID);
	}
	
	public Enrolment update(Enrolment enrolment)
	{
		return enrolmentRepository.save(enrolment);
	}
	
}
