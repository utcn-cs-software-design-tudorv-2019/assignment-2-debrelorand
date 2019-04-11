package com.csdepartment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.csdepartment.entities.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator,Integer>{
	public Administrator save(Administrator administrator);
	public Administrator findById(int ID);
	public Administrator findByUsername(String username);
	public List<Administrator> findAll();
	public boolean deleteById(int ID);
}
