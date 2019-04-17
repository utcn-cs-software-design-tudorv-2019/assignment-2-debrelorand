package com.csdepartment.mvc.model.servicies;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.csdepartment.mvc.model.entities.Administrator;
import com.csdepartment.mvc.model.repositories.AdministratorRepository;

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
		administratorRepository.deleteById(administrator.getId());
		Administrator admin = administratorRepository.findById(administrator.getId());
		
		if(admin==null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public Administrator update (Administrator administrator)
	{
		return administratorRepository.save(administrator);
	}
}
