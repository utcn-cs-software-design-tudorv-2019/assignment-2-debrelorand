package com.csdepartment;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.csdepartment.mvc.view.HomeView;
import com.csdepartment.mvc.view.NewAccountView;
import com.csdepartment.validators.*;
import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.*;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringBootApp.class)
        		.headless(false)
        		.run(args);
	}
	
	@Bean
    public HomeView HomeFrame() {
        return new HomeView();
    }
	
	
	@Bean
    public StudentModel createStudentModel() {
        return new StudentModel();
    }
	
	@Bean
    public AdministratorModel createTeacherModel() {
        return new AdministratorModel();
    }
	
	@Bean
    public HomePageController createHomePageController() {
        return new HomePageController();
    }
	
}
