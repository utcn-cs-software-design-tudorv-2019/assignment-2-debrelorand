package com.csdepartment;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import com.csdepartment.mvc.controller.HomePageController;
import com.csdepartment.mvc.model.AdministratorModel;
import com.csdepartment.mvc.model.StudentModel;
import com.csdepartment.mvc.view.HomeView;

@EnableAutoConfiguration
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
