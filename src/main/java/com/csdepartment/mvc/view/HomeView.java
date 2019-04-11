package com.csdepartment.mvc.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class HomeView extends JFrame{
	//private JFrame frame;
		private JTextField textField_Username;
		private JTextField textField_Password;
		
		JButton btnLogin;
		JButton btnNewAccount;


		/**
		 * Create the application.
		 */
		public HomeView() {
			
			setBounds(100, 100, 600, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("Student managment system");
			JPanel panelNorth = new JPanel();
			getContentPane().add(panelNorth, BorderLayout.NORTH);
			
			panelNorth.add(new ImageComponent("login.png"));
			JPanel panelCenter = new JPanel();
			getContentPane().add(panelCenter, BorderLayout.CENTER);
			panelCenter.setLayout(new MigLayout("", "[][grow][][][][]", "[][][][][][][][][][][][][][][]"));
			
			//panelCenter.add(new ImageComponent("login.png"),"cell 0 2,alignx trailing");
			
			JLabel lblUsername = new JLabel("Username:");
			panelCenter.add(lblUsername, "cell 0 4,alignx trailing");
			
			textField_Username = new JTextField("");
			panelCenter.add(textField_Username, "cell 1 4,growx");
			textField_Username.setColumns(10);
			
			JLabel lblPassword = new JLabel("Password:");
			panelCenter.add(lblPassword, "cell 0 5,alignx trailing");
			
			textField_Password = new JPasswordField("");
			panelCenter.add(textField_Password, "cell 1 5,growx");
			textField_Password.setColumns(10);
			
			btnLogin = new JButton("Login");
			/*
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String username = textField_Username.getText();
					String password = textField_Password.getText();
					
					Student student = studentBLL.getByName(username);
					if(student!=null)
					{
						if(student.getPassword().equals(password))
						{
							JOptionPane.showMessageDialog(null, "Bine ai venit, "+student.getNume()+" "+student.getPrenume()+" - student");
							StudentProfile studentprofile = new StudentProfile(student);
							setVisible(false);
							studentprofile.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Incorect password!");
						}
					}
					else
					{
						Administrator administrator = new Administrator("","",username,"","","","","");
						administrator = administratorBLL.getByName(administrator);
						if(administrator!=null)
						{
							if(administrator.getPassword().equals(password))
							{
								JOptionPane.showMessageDialog(null, "Bine ai venit, "+administrator.getNume()+" "+administrator.getPrenume()+" - administrator");
								AdministratorProfile adminprofile = new AdministratorProfile(administrator);
								setVisible(false);
								adminprofile.setVisible(true);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Incorect password!");
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "User inexistent!!!");
						}
					}
				}
			});
			*/
			panelCenter.add(btnLogin, "cell 1 6");
			
			btnNewAccount = new JButton("Nu am inca cont");
			/*
			btnNewAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					NewAccount frame2 = new NewAccount();
					frame2.setVisible(true);
				}
			});
			*/
			panelCenter.add(btnNewAccount, "cell 1 14");
			
		}
		
		public void addButtonNewAccountListener(ActionListener a1)
		{
			btnNewAccount.addActionListener(a1);
		}
		
		public void addButtonLoginListener(ActionListener a1)
		{
			btnLogin.addActionListener(a1);
		}
		
		public List<String> getTextFieldInfo()
		{
			List<String> rezultat = new ArrayList<String>();
			rezultat.add(textField_Username.getText());
			rezultat.add(textField_Password.getText());
			return rezultat;
		}
		
		class ImageComponent extends Component {

		      BufferedImage img;

		      public void paint(Graphics g) {
		         g.drawImage(img, 0, 0, null);
		      }

		      public ImageComponent(String path) {
		         try {
		            img = ImageIO.read(new File(path));
		         } catch (IOException e) {
		            e.printStackTrace();
		         }
		      }

		      public Dimension getPreferredSize() {
		         if (img == null) {
		            return new Dimension(100,100);
		         } else {
		            return new Dimension(img.getWidth(), img.getHeight());
		         }
		      }
		   }
}
