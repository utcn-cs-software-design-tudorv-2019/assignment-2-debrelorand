package com.csdepartment;

import javax.inject.Inject;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.AdministratorModel;
import com.csdepartment.mvc.model.StudentModel;
import com.csdepartment.mvc.view.HomeView;
import com.csdepartment.services.AdministratorService;
import com.csdepartment.services.StudentService;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

	@Inject
	StudentService studentService;
	@Inject
	AdministratorService administratorService;
	@Inject
	HomeView homeView;
	@Inject
	StudentModel studentModel;
	@Inject
	AdministratorModel administratorModel;
	@Inject
	HomePageController homePageController;

	public void onApplicationEvent(ContextRefreshedEvent event) {
		homePageController.init(homeView, studentModel, administratorModel);
	}
}