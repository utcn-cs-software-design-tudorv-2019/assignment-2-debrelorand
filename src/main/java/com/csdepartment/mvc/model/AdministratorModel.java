package com.csdepartment.mvc.model;

import com.csdepartment.mvc.model.entities.Administrator;

public class AdministratorModel {
	
	private Administrator administrator;

	public AdministratorModel() {
		this.administrator = new Administrator();
	}
		
	public AdministratorModel(Administrator administrator) {
		this.administrator = administrator;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}
	

}