package com.csdepartment.mvc.model;

import com.csdepartment.entities.*;

public class AdministratorModel {
	
	private Administrator administrator;

	public AdministratorModel() {
		this.administrator = new Administrator();
	}
		
	public AdministratorModel(Administrator administrator) {
		this.administrator = administrator;
	}

	public Administrator getTeacher() {
		return administrator;
	}

	public void setTeacher(Administrator administrator) {
		this.administrator = administrator;
	}
	

}