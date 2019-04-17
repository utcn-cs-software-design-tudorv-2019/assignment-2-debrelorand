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
public class AdministratorProfile extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel contentPane = new JPanel();
	public JPanel panel_center = new JPanel();
	public JPanel panel_north = new JPanel();
	
	
	private JButton viewProfile;
	private JButton updateProfile;
	private JButton deleteProfile;
	private JButton courses;
	private JButton reports;
	private JButton logout;
	
	private JLabel lblBineAiVenit = new JLabel("");
	/**
	 * Create the frame.
	 */
	public AdministratorProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("AdministratorProfile");
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new MigLayout("", "[][][][][][]", "[][][][][][]"));
				
		contentPane.add(panel_north, BorderLayout.NORTH);
		panel_north.setLayout(new MigLayout("", "[][][][][]", "[][][][]"));
		
		lblBineAiVenit.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_north.add(lblBineAiVenit, "flowx,cell 0 0");
		
		viewProfile = new JButton("View profile");
		panel_north.add(viewProfile, "flowx,cell 0 1");
		
		updateProfile = new JButton("Update");
		panel_north.add(updateProfile, "cell 0 1");
		
		deleteProfile = new JButton("Delete");
		panel_north.add(deleteProfile, "cell 0 1");
		
		courses = new JButton("Courses");
		
		panel_north.add(courses, "cell 0 1");
		
		reports = new JButton("Reports");
		/*
		reports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				panel_center.removeAll();
				panel_center.updateUI();
				
				
				List<Student> lista = studentBLL.getAll();
				
				String[] columnNames = {"ID","Nume","Email","Grupa"};
				
				String[][] data = new String[lista.size()][4];
				
				for (int i=0;i<lista.size();i++)
				{
					data[i][0]=Integer.toString(lista.get(i).getNrIdentificare());
					data[i][1]=lista.get(i).getNume()+" "+lista.get(i).getPrenume();
					data[i][2]=lista.get(i).getEmail();
					data[i][3]=lista.get(i).getGrupa();
					
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(1).setPreferredWidth(150);
				table.getColumnModel().getColumn(0).setPreferredWidth(40);
				table.getColumnModel().getColumn(2).setPreferredWidth(180);
				
				panel_center.add(sp,"cell 0 1");
				
				JLabel lbldatestart = new JLabel("Start date(dd-mm-yyyy): ");
				panel_center.add(lbldatestart, "cell 0 2,alignx trailing");
				
				JTextField textField_start = new JTextField();
				panel_center.add(textField_start, "cell 0 2,growx");
				textField_start.setColumns(20);
				
				JLabel lbldatefinish = new JLabel("Finish date(dd-mm-yyyy): ");
				panel_center.add(lbldatefinish, "cell 0 3,alignx trailing");
				
				JTextField textField_finish = new JTextField();
				panel_center.add(textField_finish, "cell 0 3,growx");
				textField_start.setColumns(20);
				
				JButton generate = new JButton("Generare");
				panel_center.add(generate,"cell 0 4,growx");
				
				JTextPane text = new JTextPane();
				text.setMinimumSize(new Dimension(100,80));
				text.setEditable(false);
				panel_center.add(text,"cell 0 5,growx");
				
				generate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						
						text.setText("ALFA OMEGA ALFA");
						
						
						try {
							SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
							java.util.Date date;
							
							date = sdf1.parse(textField_start.getText());
							
							Date startDate=new java.sql.Date(date.getTime());
							date = sdf1.parse(textField_finish.getText());
							Date finishDate=new java.sql.Date(date.getTime());
							
							float nota = 0;
							int nr_nota=0;
							
							String rezultat="";
							
							Enrolment enrolment = new Enrolment(null,null,null,-1,Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0)),-1);
							
							List<Enrolment> enrolments = enrolmentBLL.getById(enrolment);
							for(int i=0;i<enrolments.size();i++)
							{
								if(enrolments.get(i).getStartDate().getTime()>=startDate.getTime() && enrolments.get(i).getFinishDate().getTime()<=finishDate.getTime())
								{
									rezultat+=(enrolments.get(i).getCurs().getNume()+", nota: "+enrolments.get(i).getNota()+"\n");
									nota+=enrolments.get(i).getNota()*enrolments.get(i).getCurs().getCredit();
									nr_nota+=enrolments.get(i).getCurs().getCredit();
								}
							}
							
							rezultat+=("Media pe perioada respectiva: "+nota/(float)nr_nota);
							text.setText(rezultat);
							
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
			}
		});
		*/
		panel_north.add(reports,"cell 0 1");
		
		logout = new JButton("Logout");
		/*
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home home = new Home();
				home.setVisible(true);
			}
		});
		*/
		panel_north.add(logout, "cell 1 1");
	}
	public void addButtonLogoutListener(ActionListener a1)
	{
		logout.addActionListener(a1);
	}
	public void addButtonReportsListener(ActionListener a1)
	{
		reports.addActionListener(a1);
	}
	public void addButtonCoursesListener(ActionListener a1)
	{
		courses.addActionListener(a1);
	}
	
	public void addButtonDeleteListener(ActionListener a1)
	{
		deleteProfile.addActionListener(a1);
	}

	public void addButtonViewUpdateListener(ActionListener a1)
	{
		updateProfile.addActionListener(a1);
	}

	public void addButtonViewProfileListener(ActionListener a1)
	{
		viewProfile.addActionListener(a1);
	}

	
	public void setWelcomeText(String text)
	{
		
		lblBineAiVenit.setText("Bine ai venit, "+text);
	}
	
}
