package com.csdepartment.mvc.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class StudentProfile extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane = new JPanel();
	public JPanel panel_center = new JPanel();
	public JPanel panel_north = new JPanel();
	
	private JLabel lblBineAiVenit;
	private JButton viewProfile;
	private JButton updateProfile;
	private JButton deleteProfile;
	private JButton enrolments;	
	private JButton grades;
	private JButton logout;
	
	/**
	 * Create the frame.
	 */
	public StudentProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("StudentProfile");
		setBounds(100, 100, 600, 500);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][]"));
				
		
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new MigLayout("", "[][][][][]", "[][]"));
		
		lblBineAiVenit = new JLabel("");
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
		
		viewProfile = new JButton("View profile");
		panel_north.add(viewProfile, "flowx,cell 0 1");
		
		updateProfile = new JButton("Update");
		panel_north.add(updateProfile, "cell 0 1");
		
		deleteProfile = new JButton("Delete");
		panel_north.add(deleteProfile, "cell 0 1");
		
		enrolments = new JButton("Enrolments");
		panel_north.add(enrolments, "cell 0 1");
		
		grades = new JButton("Grades");
		panel_north.add(grades,"cell 0 1");
		
		logout = new JButton("Logout");
		panel_north.add(logout, "cell 1 1");
		
		
	}

	public void addButtonViewProfileListener(ActionListener a1)
	{
		viewProfile.addActionListener(a1);
	}
	
	public void addButtonUpdateProfileListener(ActionListener a1)
	{
		updateProfile.addActionListener(a1);
	}
	
	public void addButtonDeleteProfileListener(ActionListener a1)
	{
		deleteProfile.addActionListener(a1);
	}
	
	public void addButtonEnrolmentsListener(ActionListener a1)
	{
		enrolments.addActionListener(a1);
	}
	
	public void addButtonGradesListener(ActionListener a1)
	{
		grades.addActionListener(a1);
	}
	
	public void addButtonLogoutListener(ActionListener a1)
	{
		logout.addActionListener(a1);
	}
	
	public void setWelcomeText(String text)
	{
		lblBineAiVenit.setText("Bine ai venit, "+text);
	}
}
