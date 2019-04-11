package com.csdepartment.services;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.entities.Administrator;
import com.csdepartment.repositories.AdministratorRepository;

@Service()
public class AdministratorService {
	@Inject 
	AdministratorRepository administratorRepository;
	
	public int registerAdministrator(Administrator administrator)
	{
		return administratorRepository.save(administrator).getId();
	}
	
	public Administrator getById(int ID)
	{
		return administratorRepository.findById(ID);
	}
	
	public Administrator getByUsername(String username)
	{
		return administratorRepository.findByUsername(username);
	}
	
	public boolean deleteAdministrator(Administrator administrator)
	{
		return administratorRepository.deleteById(administrator.getId());
	}
}
