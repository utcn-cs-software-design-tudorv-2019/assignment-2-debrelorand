package com.csdepartment.mvc.view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.csdepartment.mvc.model.entities.Administrator;
import com.csdepartment.mvc.model.entities.Student;

import net.miginfocom.swing.MigLayout;

public class NewAccountView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField textField_Nume;
	private JTextField textField_Prenume;
	private JTextField textField_Adresa;
	private JTextField textField_CNP;
	private JTextField textField_Email;
	private JTextField textField_Grupa;
	
	JRadioButton rdbtnStudent;
	JRadioButton rdbtnAdministrator;
	JButton btnRegister;
	JButton btnClose;
	
	
	public NewAccountView() {
		setBounds(150, 150, 550, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Select one:");
		getContentPane().add(lblNewLabel, "cell 0 0");
		
		
		
		JLabel lblUsername = new JLabel("Username:");
		getContentPane().add(lblUsername, "cell 0 1,alignx trailing");
		
		textField_Username = new JTextField("");
		getContentPane().add(textField_Username, "cell 1 1,growx");
		textField_Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		getContentPane().add(lblPassword, "cell 0 2,alignx trailing");
		
		textField_Password = new JPasswordField("");
		getContentPane().add(textField_Password, "cell 1 2,growx");
		textField_Password.setColumns(10);
		
		JLabel lblNume = new JLabel("Nume:");
		getContentPane().add(lblNume, "cell 0 3,alignx trailing");
		
		textField_Nume = new JTextField("");
		getContentPane().add(textField_Nume, "cell 1 3,growx");
		textField_Nume.setColumns(10);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		getContentPane().add(lblPrenume, "cell 0 4,alignx trailing");
		
		textField_Prenume = new JTextField("");
		getContentPane().add(textField_Prenume, "cell 1 4,growx");
		textField_Prenume.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		getContentPane().add(lblAdresa, "cell 0 5,alignx trailing");
		
		textField_Adresa = new JTextField("");
		getContentPane().add(textField_Adresa, "cell 1 5,growx");
		textField_Adresa.setColumns(10);
		
		JLabel lblCnp = new JLabel("CNP:");
		getContentPane().add(lblCnp, "cell 0 6,alignx trailing");
		
		textField_CNP = new JTextField("");
		getContentPane().add(textField_CNP, "cell 1 6,growx");
		textField_CNP.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		getContentPane().add(lblEmail, "cell 0 7,alignx trailing");
		
		rdbtnStudent = new JRadioButton("Student");
		getContentPane().add(rdbtnStudent, "flowx,cell 1 0");
		
		rdbtnAdministrator = new JRadioButton("Administrator");
		getContentPane().add(rdbtnAdministrator, "cell 1 0");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnStudent);
		group.add(rdbtnAdministrator);
		
		textField_Email = new JTextField("");
		getContentPane().add(textField_Email, "cell 1 7,growx");
		textField_Email.setColumns(10);
		
		JLabel lblGrupa = new JLabel("Grupa/Catedra:");
		getContentPane().add(lblGrupa, "cell 0 8,alignx trailing");
		
		btnRegister = new JButton("Register");
	
		textField_Grupa = new JTextField("");
		getContentPane().add(textField_Grupa, "cell 1 8,growx");
		textField_Grupa.setColumns(10);
		getContentPane().add(btnRegister, "flowx,cell 1 9");
		
		btnClose = new JButton("Close");
		getContentPane().add(btnClose, "cell 1 9");
	}
	
	public String checkRadioButton() 
	{
		if (rdbtnStudent.isSelected())
		{
			return "STUDENT";
		}
		else
		{
			if (rdbtnAdministrator.isSelected())
			{
				return "ADMINISTRATOR";
			}
			else
			{
				return "ERROR";
			}
			
		}
	}
	
	public Student getStudentInfo() {
		if(rdbtnStudent.isSelected()) {
			String username = textField_Username.getText();
			String password = textField_Password.getText();
			String nume = textField_Nume.getText();
			String prenume = textField_Prenume.getText();
			String cnp = textField_CNP.getText();
			String adresa = textField_Adresa.getText();
			String email = textField_Email.getText();
			String grupa = textField_Grupa.getText();
			//public Student(int idStudent, String nume, String prenume, String username, String password, String cnp,	String adresa, String email, String grupa)
			Student student = new Student(nume,prenume,username,password,cnp,adresa,email,grupa);
			return student;
		}
		else
		{
			return null;
		}
	}
	
	public Administrator getAdminInfo() {
		if(rdbtnAdministrator.isSelected()) {
			String username = textField_Username.getText();
			String password = textField_Password.getText();
			String nume = textField_Nume.getText();
			String prenume = textField_Prenume.getText();
			String cnp = textField_CNP.getText();
			String adresa = textField_Adresa.getText();
			String email = textField_Email.getText();
			String catedra = textField_Grupa.getText();

			Administrator administrator = new Administrator(nume,prenume,username,password,cnp,adresa,email,catedra);
			return administrator;
		}
		else
		{
			return null;
		}
	}
	
	public void addButtonRegisterListener(ActionListener a1) {
		btnRegister.addActionListener(a1);
	}
	
	public void addButtonCloseListener(ActionListener a1) {
		btnClose.addActionListener(a1);
	}

}
