package com.csdepartment.mvc.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.csdepartment.mvc.model.entities.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer>{
	@SuppressWarnings("unchecked")
	public Administrator save(Administrator administrator);
	public Administrator findById(int ID);
	public Administrator findByUsername(String username);
	public List<Administrator> findAll();
	public void deleteById(int ID);
}
