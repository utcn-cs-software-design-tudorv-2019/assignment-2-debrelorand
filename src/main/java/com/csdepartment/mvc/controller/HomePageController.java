package com.csdepartment.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JOptionPane;

import com.csdepartment.entities.Administrator;
import com.csdepartment.entities.Student;
import com.csdepartment.mvc.model.AdministratorModel;
import com.csdepartment.mvc.model.StudentModel;
import com.csdepartment.mvc.view.HomeView;
import com.csdepartment.mvc.view.NewAccountView;
import com.csdepartment.services.AdministratorService;
import com.csdepartment.services.StudentService;

public class HomePageController {

	@Inject
	StudentService studentService;
	@Inject
	AdministratorService administratorService;

	private StudentModel studentModel;
	private AdministratorModel administratorModel;

	private HomeView homeView;
	private NewAccountView newAccountView;


	public void init(HomeView homeView, StudentModel studentModel, AdministratorModel administratorModel) {
		this.homeView = homeView;
		
		this.studentModel = studentModel;
		this.administratorModel = administratorModel;

		this.homeView.setVisible(true);

	
		this.studentModel = new StudentModel();
		this.administratorModel = new AdministratorModel();

		
		///////////////////////////////////////////////////////HomeView///////////////////////////////////////////////////////
		this.homeView.addButtonLoginListener(new BtnLoginListener());
		this.homeView.addButtonNewAccountListener(new BtnNewAccountListener());
		
		
		///////////////////////////////////////////////////////NewAccountView///////////////////////////////////////////////////////
		this.newAccountView = new NewAccountView();
		newAccountView.addButtonRegisterListener(new BtnRegisterListener());
		newAccountView.addButtonCloseListener(new ButtonCloseListener());
		

	}

	////////////////////////////////////////////////////////////Home CLASS///////////////////////////////////////////////////////
	class BtnLoginListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> info = homeView.getTextFieldInfo();
			String username = info.get(0);
			String password = info.get(1);
			System.out.println(username+" "+password);
			
			Student student = studentService.getByUsername(username);
			//Student student = studentService.getByID(6);
			System.out.println(student);
			
		}
		
	}
	
	class BtnNewAccountListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			homeView.setVisible(false);
			newAccountView.setVisible(true);
		}
		
	}
	
	
	////////////////////////////////////////////////////////////NewAccountView CLASS///////////////////////////////////////////////////////
	class BtnRegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String radio = newAccountView.checkRadioButton();
			if(radio.equals("STUDENT"))
			{
				try {
					Student student = newAccountView.getStudentInfo();
					//register.validate(student);
					int id = studentService.registerStudent(student);
					JOptionPane.showMessageDialog(null, "Account created, id:"+id);
					newAccountView.setVisible(false);
				}
				catch(IllegalArgumentException e1)
				{
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			else
			{
				if(radio.equals("ADMINISTRATOR"))
				{
					Administrator admin = newAccountView.getAdminInfo();
					int id = administratorService.registerAdministrator(admin);
					JOptionPane.showMessageDialog(null, "Account created, id:"+id);
					newAccountView.setVisible(false);
				}
				else
				{
					//error
				}
			}
			
			
		}
		
	}
	class ButtonCloseListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			newAccountView.setVisible(false);
			homeView.setVisible(true);
		}
	}
}
