package com.csdepartment.mvc.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.csdepartment.mvc.model.AdministratorModel;
import com.csdepartment.mvc.model.StudentModel;
import com.csdepartment.mvc.model.entities.Administrator;
import com.csdepartment.mvc.model.entities.Course;
import com.csdepartment.mvc.model.entities.Enrolment;
import com.csdepartment.mvc.model.entities.Student;
import com.csdepartment.mvc.model.servicies.AdministratorService;
import com.csdepartment.mvc.model.servicies.CourseService;
import com.csdepartment.mvc.model.servicies.EnrolmentService;
import com.csdepartment.mvc.model.servicies.StudentService;
import com.csdepartment.mvc.model.validators.RegisterValidator;
import com.csdepartment.mvc.view.AdministratorProfile;
import com.csdepartment.mvc.view.HomeView;
import com.csdepartment.mvc.view.InfoCurs;
import com.csdepartment.mvc.view.NewAccountView;
import com.csdepartment.mvc.view.StudentProfile;

public class HomePageController {

	@Inject
	StudentService studentService;
	@Inject
	AdministratorService administratorService;
	@Inject
	CourseService courseService;
	@Inject
	EnrolmentService enrolmentService;

	private StudentModel studentModel;
	private AdministratorModel administratorModel;

	private HomeView homeView;
	private NewAccountView newAccountView;
	private StudentProfile studentProfileView;
	private AdministratorProfile administratorProfileView;
	private InfoCurs cursInfoView;

	private RegisterValidator register = new RegisterValidator();

	public void init(HomeView homeView, StudentModel studentModel, AdministratorModel administratorModel) {
		this.homeView = homeView;
		this.homeView.setVisible(true);
		
		this.studentModel = studentModel;
		this.administratorModel = administratorModel;

		this.studentModel = new StudentModel();
		this.administratorModel = new AdministratorModel();

		///////////////////////////////////////////////////////HomeView///////////////////////////////////////////////////////
		this.homeView.addButtonLoginListener(new HomeView_BtnLoginListener());
		this.homeView.addButtonNewAccountListener(new HomeView_BtnNewAccountListener());
		
		
		///////////////////////////////////////////////////////NewAccountView///////////////////////////////////////////////////////
		this.newAccountView = new NewAccountView();
		newAccountView.addButtonRegisterListener(new NewAccountView_BtnRegisterListener());
		newAccountView.addButtonCloseListener(new NewAccountView_ButtonCloseListener());
		
		
		///////////////////////////////////////////////////////StudentProfileView///////////////////////////////////////////////////////
		this.studentProfileView = new StudentProfile();
		this.studentProfileView.addButtonViewProfileListener(new StudentProfileView_ButtonViewProfile());
		this.studentProfileView.addButtonUpdateProfileListener(new StudentProfileView_ButtonUpdateProfile());
		this.studentProfileView.addButtonDeleteProfileListener(new StudentProfileView_ButtonDeleteProfile());
		this.studentProfileView.addButtonEnrolmentsListener(new StudentPorfileView_Enrolments());
		this.studentProfileView.addButtonGradesListener(new StudentProfileView_Grades());
		this.studentProfileView.addButtonLogoutListener(new StudentProfileView_Logout());

		///////////////////////////////////////////////////////AdminsitratorProfileView///////////////////////////////////////////////////////
		this.administratorProfileView=new AdministratorProfile();
		this.administratorProfileView.addButtonViewProfileListener(new AdministratorProfileView_ButtonViewProfile());
		this.administratorProfileView.addButtonViewUpdateListener(new AdministratorProfileView_ButtonUpdateProfile());
		this.administratorProfileView.addButtonDeleteListener(new AdministratorProfileView_ButtonDeleteProfile());
		this.administratorProfileView.addButtonCoursesListener(new AdministratorProfileView_Courses());
		this.administratorProfileView.addButtonReportsListener(new AdministratorProfileView_Reports());
		this.administratorProfileView.addButtonLogoutListener(new AdminsitratorProfileView_Logout());
		
		///////////////////////////////////////////////////////CursInfoView///////////////////////////////////////////////////////
		this.cursInfoView = new InfoCurs();
		this.cursInfoView.addButtonAddNotaListener(new CursInfoView_AddNota());
		this.cursInfoView.addButtonInapoiListener(new CursInfoView_Inapoi());
		
		
	}
	
	///////////////////////////////////////////////////////CursInfoView CLASS///////////////////////////////////////////////////////	
	class CursInfoView_AddNota implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int id = Integer.parseInt((String)cursInfoView.table2.getValueAt(cursInfoView.table2.getSelectedRow(),0));
			
			Enrolment enrolment = enrolmentService.getByIdEnrolment(id);
			enrolment.setNota(cursInfoView.getNota());
			Enrolment newEnrolment = enrolmentService.update(enrolment);
			if(newEnrolment!=null)
			{
				JOptionPane.showMessageDialog(null, "Succes!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Erroare la inserare!");
			}
			
			cursInfoView.setVisible(false);
			cursInfoView = new InfoCurs();
			administratorProfileView.setVisible(true);//
		}
	}
	class CursInfoView_Inapoi implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cursInfoView.setVisible(false);
			cursInfoView = new InfoCurs();
			administratorProfileView.setVisible(true);
		}
	}
	
	////////////////////////////////////////////////////////////AdministratorProfileView CLASS///////////////////////////////////////////////////////
	class AdministratorProfileView_Reports implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			administratorProfileView.panel_center.removeAll();
			administratorProfileView.panel_center.updateUI();
			
			
			List<Student> lista = studentService.getAll();
			
			String[] columnNames = {"ID","Nume","Email","Grupa"};
			
			String[][] data = new String[lista.size()][4];
			
			for (int i=0;i<lista.size();i++)
			{
				data[i][0]=Integer.toString(lista.get(i).getIdStudent());
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
			
			administratorProfileView.panel_center.add(sp,"cell 0 1");
			
			JLabel lbldatestart = new JLabel("Start date(dd-mm-yyyy): ");
			administratorProfileView.panel_center.add(lbldatestart, "cell 0 2,alignx trailing");
			
			JTextField textField_start = new JTextField();
			administratorProfileView.panel_center.add(textField_start, "cell 0 2,growx");
			textField_start.setColumns(20);
			
			JLabel lbldatefinish = new JLabel("Finish date(dd-mm-yyyy): ");
			administratorProfileView.panel_center.add(lbldatefinish, "cell 0 3,alignx trailing");
			
			JTextField textField_finish = new JTextField();
			administratorProfileView.panel_center.add(textField_finish, "cell 0 3,growx");
			textField_start.setColumns(20);
			
			JButton generate = new JButton("Generare");
			administratorProfileView.panel_center.add(generate,"cell 0 4,growx");
			
			JTextPane text = new JTextPane();
			text.setMinimumSize(new Dimension(100,80));
			text.setEditable(false);
			administratorProfileView.panel_center.add(text,"cell 0 5,growx");
			
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
						
						
						List<Enrolment> enrolments = enrolmentService.getAllByIdStudent(Integer.parseInt((String)table.getValueAt(table.getSelectedRow(),0)));
						System.out.println(enrolments);
						for(int i=0;i<enrolments.size();i++)
						{
							if(enrolments.get(i).getStartDate().getTime()>=startDate.getTime() && enrolments.get(i).getFinishDate().getTime()<=finishDate.getTime())
							{
								rezultat+=(enrolments.get(i).getCourse().getNume()+", nota: "+enrolments.get(i).getNota()+"\n");
								nota+=enrolments.get(i).getNota()*enrolments.get(i).getCourse().getCredit();
								nr_nota+=enrolments.get(i).getCourse().getCredit();
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
	}
	class AdministratorProfileView_ButtonViewProfile implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			administratorProfileView.panel_center.removeAll();
			administratorProfileView.panel_center.updateUI();
			
			JLabel lblUsername = new JLabel("Username: "+administratorModel.getAdministrator().getUsername());
			administratorProfileView.panel_center.add(lblUsername, "cell 0 0");
			
			JLabel lblAdresa = new JLabel("Adresa: "+administratorModel.getAdministrator().getAdresa());
			administratorProfileView.panel_center.add(lblAdresa, "cell 0 1");
			
			JLabel lblEmail = new JLabel("Email: "+administratorModel.getAdministrator().getEmail());
			administratorProfileView.panel_center.add(lblEmail, "cell 0 2");
			
			JLabel lblGrupa = new JLabel("Catedra: "+administratorModel.getAdministrator().getCatedra());
			administratorProfileView.panel_center.add(lblGrupa, "cell 0 3");
			
			JLabel lblCnp = new JLabel("CNP: "+administratorModel.getAdministrator().getCnp());
			administratorProfileView.panel_center.add(lblCnp, "cell 0 4");
			
			JLabel lblId = new JLabel("ID: "+administratorModel.getAdministrator().getId());
			administratorProfileView.panel_center.add(lblId, "cell 0 5");
		}
	}
	class AdministratorProfileView_ButtonUpdateProfile implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			administratorProfileView.panel_center.removeAll();
			administratorProfileView.panel_center.updateUI();
			
			JLabel lblUsername = new JLabel("Username: ");
			administratorProfileView.panel_center.add(lblUsername, "cell 0 0,alignx trailing");
			
			JTextField textField_Username = new JTextField(administratorModel.getAdministrator().getUsername());
			administratorProfileView.panel_center.add(textField_Username, "cell 1 0,growx");
			textField_Username.setColumns(20);
			textField_Username.setEditable(false);
			
			JLabel lblAdresa = new JLabel("Adresa: ");
			administratorProfileView.panel_center.add(lblAdresa, "cell 0 1,alignx trailing");
			
			JTextField textField_Adresa = new JTextField(administratorModel.getAdministrator().getAdresa());
			administratorProfileView.panel_center.add(textField_Adresa, "cell 1 1,growx");
			textField_Adresa.setColumns(20);
			
			JLabel lblEmail = new JLabel("Email: ");
			administratorProfileView.panel_center.add(lblEmail, "cell 0 2,alignx trailing");
			
			JTextField textField_Email = new JTextField(administratorModel.getAdministrator().getEmail());
			administratorProfileView.panel_center.add(textField_Email, "cell 1 2,growx");
			textField_Email.setColumns(20);
			
			JLabel lblGrupa = new JLabel("Catedra: ");
			administratorProfileView.panel_center.add(lblGrupa, "cell 0 3,alignx trailing");
			
			JTextField textField_Grupa = new JTextField(administratorModel.getAdministrator().getCatedra());
			administratorProfileView.panel_center.add(textField_Grupa, "cell 1 3,growx");
			textField_Grupa.setColumns(20);
			
			JLabel lblCnp = new JLabel("CNP: ");
			administratorProfileView.panel_center.add(lblCnp, "cell 0 4,alignx trailing");
			
			JTextField textField_CNP = new JTextField(administratorModel.getAdministrator().getCnp());
			administratorProfileView.panel_center.add(textField_CNP, "cell 1 4,growx");
			textField_CNP.setColumns(20);
			
			JLabel lblNume = new JLabel("Nume: ");
			administratorProfileView.panel_center.add(lblNume,"cell 0 5,alignx trailing");
			
			JTextField textField_Nume = new JTextField(administratorModel.getAdministrator().getNume());
			administratorProfileView.panel_center.add(textField_Nume,"cell 1 5,growx");
			textField_Nume.setColumns(20);
			
			JLabel lblPrenume = new JLabel("Prenume:");
			administratorProfileView.panel_center.add(lblPrenume,"cell 0 6,alignx trailing");
			
			JTextField textField_Prenume = new JTextField(administratorModel.getAdministrator().getPrenume());
			administratorProfileView.panel_center.add(textField_Prenume,"cell 1 6,growx");
			textField_Prenume.setColumns(20);
			
			JLabel lblPassword = new JLabel("Password:");
			administratorProfileView.panel_center.add(lblPassword,"cell 0 7,alignx trailing");
			
			JTextField textField_parola = new JPasswordField();
			administratorProfileView.panel_center.add(textField_parola,"cell 1 7,growx");
			textField_parola.setColumns(20);
			
			JLabel lblId = new JLabel("Nr card: ");
			administratorProfileView.panel_center.add(lblId, "cell 0 8, alignx trailing");
			
			JTextField textField_Card = new JTextField(Integer.toString(administratorModel.getAdministrator().getId()));
			administratorProfileView.panel_center.add(textField_Card, "cell 1 8,growx");
			textField_Card.setColumns(20);
			textField_Card.setEditable(false);
			
			JButton update = new JButton("Update");
			administratorProfileView.panel_center.add(update,"cell 0 9,growx");
			
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					administratorModel.getAdministrator().setAdresa(textField_Adresa.getText());
					administratorModel.getAdministrator().setEmail(textField_Email.getText());
					administratorModel.getAdministrator().setCatedra(textField_Grupa.getText());
					administratorModel.getAdministrator().setCnp(textField_CNP.getText());
					administratorModel.getAdministrator().setNume(textField_Nume.getText());
					administratorModel.getAdministrator().setPrenume(textField_Prenume.getText());
					administratorModel.getAdministrator().setPassword(textField_parola.getText());
					
					Administrator admin = administratorService.update(administratorModel.getAdministrator());
					
					if(admin!=null)
					{
						administratorModel.setAdministrator(admin);
						JOptionPane.showMessageDialog(null, "Updateul s-a efectuat cu succes!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ERROR!");
					}
				}
			});
		}
	}
	class AdministratorProfileView_ButtonDeleteProfile implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(administratorService.deleteAdministrator(administratorModel.getAdministrator()))
			{
				JOptionPane.showMessageDialog(null, "Administrator sters cu succes!");
				administratorModel.setAdministrator(null);
				administratorProfileView.setVisible(false);
				homeView.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR!");
			}
		}
		
	}
	class AdministratorProfileView_Courses implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			administratorProfileView.panel_center.removeAll();
			administratorProfileView.panel_center.updateUI();
			
			List<Course> courses = courseService.getByIdAdministrator(administratorModel.getAdministrator().getId());
		
			String[] columnNames = {"ID","Nume disciplina","Credit"};
			
			String[][] data = new String[courses.size()][3];
			
			for (int i=0;i<courses.size();i++)
			{
				data[i][0]=Integer.toString(courses.get(i).getIdCourse());
				data[i][1]=courses.get(i).getNume();
				data[i][2]=Integer.toString(courses.get(i).getCredit());
			}
			
			JTable table = new JTable(data,columnNames);
			
			JScrollPane sp = new JScrollPane(table);
			table.setVisible(true);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(330);
			
			administratorProfileView.panel_center.add(sp,"cell 0 1");
			
			JButton coursInfo = new JButton("Curs info");
			administratorProfileView.panel_center.add(coursInfo,"cell 0 2");
			
			coursInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					String string = "ID curs: "+Integer.parseInt((String)table.getValueAt(row, 0))+" - "+(String)table.getValueAt(row, 1)+", nr credite: "+Integer.parseInt((String)table.getValueAt(row, 2));
					
					cursInfoView.panel_center.removeAll();
					cursInfoView.panel_center.updateUI();
					cursInfoView.setBineAiVenitText(string);
					cursInfoView.setVisible(true);
					homeView.setVisible(false);
					
					List<Enrolment> enrollments = enrolmentService.getAllByIdCourse(Integer.parseInt((String)table.getValueAt(row, 0)));
					
					
					String[] columnNames = {"ID","Student","Start date","Finish date","Nota"};
					
					String[][] data = new String[enrollments.size()][5];
					
					for (int i=0;i<enrollments.size();i++)
					{
						data[i][1]=enrollments.get(i).getStudent().getNume()+" "+enrollments.get(i).getStudent().getPrenume();
						data[i][0]=Integer.toString(enrollments.get(i).getIdEnrolment());
						data[i][2]=enrollments.get(i).getStartDate().toString();
						data[i][3]=enrollments.get(i).getFinishDate().toString();
						
						int nota = enrollments.get(i).getNota();
						if(nota==-1)
						{
							data[i][4]="Neterminat";
						}
						else
						{
							data[i][4]=Integer.toString(nota);
						}
					}
					
					cursInfoView.table2 = new JTable(data,columnNames);
					
					JScrollPane sp = new JScrollPane(cursInfoView.table2);
					cursInfoView.table2.setVisible(true);
					
					cursInfoView.table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					cursInfoView.table2.getColumnModel().getColumn(1).setPreferredWidth(180);
					cursInfoView.table2.getColumnModel().getColumn(0).setPreferredWidth(40);
					
					cursInfoView.panel_center.add(sp,"cell 0 3");
					
					
					cursInfoView.addButtoanele();
					cursInfoView.panel_center.updateUI();
				}
			});
			
			JLabel text = new JLabel("Adaugare curs:");
			administratorProfileView.panel_center.add(text,"cell 0 3");
			
			JLabel lblNume = new JLabel("Nume: ");
			administratorProfileView.panel_center.add(lblNume, "cell 0 4,alignx trailing");
			
			JTextField textField_Nume = new JTextField();
			administratorProfileView.panel_center.add(textField_Nume, "cell 0 4,growx");
			textField_Nume.setColumns(20);
			
			JLabel lblCredit = new JLabel("Credit: ");
			administratorProfileView.panel_center.add(lblCredit, "cell 0 5,alignx trailing");
			
			JTextField textField_Credit = new JTextField();
			administratorProfileView.panel_center.add(textField_Credit, "cell 0 5,growx");
			textField_Credit.setColumns(20);
			
			JButton button = new JButton("Adaugare");
			administratorProfileView.panel_center.add(button,"cell 0 6,growx");
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Course curs = new Course(administratorModel.getAdministrator(),textField_Nume.getText(),Integer.parseInt(textField_Credit.getText()));
					
					Course newCourse = courseService.makeCourse(curs);
					
					if(newCourse==null)
					{
						JOptionPane.showMessageDialog(null, "ERROR!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Succes, id:"+newCourse.getIdCourse());
					}
				}
			});
		}
	}
	class AdminsitratorProfileView_Logout implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			administratorProfileView.setVisible(false);
			administratorProfileView=new AdministratorProfile();
			administratorProfileView.addButtonViewProfileListener(new AdministratorProfileView_ButtonViewProfile());
			administratorProfileView.addButtonViewUpdateListener(new AdministratorProfileView_ButtonUpdateProfile());
			administratorProfileView.addButtonDeleteListener(new AdministratorProfileView_ButtonDeleteProfile());
			administratorProfileView.addButtonCoursesListener(new AdministratorProfileView_Courses());
			administratorProfileView.addButtonReportsListener(new AdministratorProfileView_Reports());
			homeView.setVisible(true);
		}
		
	}
	////////////////////////////////////////////////////////////StudentProfileView CLASS///////////////////////////////////////////////////////
	class StudentProfileView_ButtonViewProfile implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
					studentProfileView.panel_center.removeAll();
					studentProfileView.panel_center.updateUI();
					
					JLabel lblUsername = new JLabel("Username: "+studentModel.getStudent().getUsername());
					studentProfileView.panel_center.add(lblUsername, "cell 0 0");
					
					JLabel lblAdresa = new JLabel("Adresa: "+studentModel.getStudent().getAdresa());
					studentProfileView.panel_center.add(lblAdresa, "cell 0 1");
					
					JLabel lblEmail = new JLabel("Email: "+studentModel.getStudent().getEmail());
					studentProfileView.panel_center.add(lblEmail, "cell 0 2");
					
					JLabel lblGrupa = new JLabel("Grupa: "+studentModel.getStudent().getGrupa());
					studentProfileView.panel_center.add(lblGrupa, "cell 0 3");
					
					JLabel lblCnp = new JLabel("CNP: "+studentModel.getStudent().getCnp());
					studentProfileView.panel_center.add(lblCnp, "cell 0 4");
					
					JLabel lblId = new JLabel("Nr card: "+studentModel.getStudent().getIdStudent());
					studentProfileView.panel_center.add(lblId, "cell 0 5");
		}
		
	}
	class StudentProfileView_ButtonUpdateProfile implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			studentProfileView.panel_center.removeAll();
			studentProfileView.panel_center.updateUI();
			
			JLabel lblUsername = new JLabel("Username: ");
			studentProfileView.panel_center.add(lblUsername, "cell 0 0,alignx trailing");
			
			JTextField textField_Username = new JTextField(studentModel.getStudent().getUsername());
			studentProfileView.panel_center.add(textField_Username, "cell 1 0,growx");
			textField_Username.setColumns(20);
			textField_Username.setEditable(false);
			
			JLabel lblAdresa = new JLabel("Adresa: ");
			studentProfileView.panel_center.add(lblAdresa, "cell 0 1,alignx trailing");
			
			JTextField textField_Adresa = new JTextField(studentModel.getStudent().getAdresa());
			studentProfileView.panel_center.add(textField_Adresa, "cell 1 1,growx");
			textField_Adresa.setColumns(20);
			
			JLabel lblEmail = new JLabel("Email: ");
			studentProfileView.panel_center.add(lblEmail, "cell 0 2,alignx trailing");
			
			JTextField textField_Email = new JTextField(studentModel.getStudent().getEmail());
			studentProfileView.panel_center.add(textField_Email, "cell 1 2,growx");
			textField_Email.setColumns(20);
			
			JLabel lblGrupa = new JLabel("Grupa: ");
			studentProfileView.panel_center.add(lblGrupa, "cell 0 3,alignx trailing");
			
			JTextField textField_Grupa = new JTextField(studentModel.getStudent().getGrupa());
			studentProfileView.panel_center.add(textField_Grupa, "cell 1 3,growx");
			textField_Grupa.setColumns(20);
			
			JLabel lblCnp = new JLabel("CNP: ");
			studentProfileView.panel_center.add(lblCnp, "cell 0 4,alignx trailing");
			
			JTextField textField_CNP = new JTextField(studentModel.getStudent().getCnp());
			studentProfileView.panel_center.add(textField_CNP, "cell 1 4,growx");
			textField_CNP.setColumns(20);
			
			JLabel lblNume = new JLabel("Nume: ");
			studentProfileView.panel_center.add(lblNume,"cell 0 5,alignx trailing");
			
			JTextField textField_Nume = new JTextField(studentModel.getStudent().getNume());
			studentProfileView.panel_center.add(textField_Nume,"cell 1 5,growx");
			textField_Nume.setColumns(20);
			
			JLabel lblPrenume = new JLabel("Prenume:");
			studentProfileView.panel_center.add(lblPrenume,"cell 0 6,alignx trailing");
			
			JTextField textField_Prenume = new JTextField(studentModel.getStudent().getPrenume());
			studentProfileView.panel_center.add(textField_Prenume,"cell 1 6,growx");
			textField_Prenume.setColumns(20);
			
			JLabel lblPassword = new JLabel("Password:");
			studentProfileView.panel_center.add(lblPassword,"cell 0 7,alignx trailing");
			
			JTextField textField_parola = new JPasswordField();
			studentProfileView.panel_center.add(textField_parola,"cell 1 7,growx");
			textField_parola.setColumns(20);
			
			JLabel lblId = new JLabel("Nr card: ");
			studentProfileView.panel_center.add(lblId, "cell 0 8, alignx trailing");
			
			JTextField textField_Card = new JTextField(Integer.toString(studentModel.getStudent().getIdStudent()));
			studentProfileView.panel_center.add(textField_Card, "cell 1 8,growx");
			textField_Card.setColumns(20);
			textField_Card.setEditable(false);
			
			JButton update = new JButton("Update");
			studentProfileView.panel_center.add(update,"cell 0 9,growx");
			
			update.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					studentModel.getStudent().setAdresa(textField_Adresa.getText());
					studentModel.getStudent().setEmail(textField_Email.getText());
					studentModel.getStudent().setGrupa(textField_Grupa.getText());
					studentModel.getStudent().setCnp(textField_CNP.getText());
					studentModel.getStudent().setNume(textField_Nume.getText());
					studentModel.getStudent().setPrenume(textField_Prenume.getText());
					studentModel.getStudent().setPassword(textField_parola.getText());
					
					Student student = studentService.update(studentModel.getStudent());
					
					
					if(student!=null)
					{
						studentModel.setStudent(student);
						JOptionPane.showMessageDialog(null, "Updated successfully!");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ERROR!");
					}
				}
			});
		}
	}
	class StudentProfileView_ButtonDeleteProfile implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			if(studentService.deleteStudent(studentModel.getStudent()))
			{
				JOptionPane.showMessageDialog(null, "Student sters cu succes!");
				studentModel.setStudent(null);
				studentProfileView.setVisible(false);
				homeView.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ERROR!");
			}
			
		}
	}
	class StudentPorfileView_Enrolments implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			studentProfileView.panel_center.removeAll();
			studentProfileView.panel_center.updateUI();
			
			JLabel info = new JLabel("Selecteaza un curs:");
			studentProfileView.panel_center.add(info,"cell 0 0");
			
			List<Course> cursurile = courseService.getAll();
			
			String[] columnNames = {"ID","IdAdministrator","Nume administrator","Nume disciplina","Nr de credite"};
			
			String[][] data = new String[cursurile.size()][5];
			
			for (int i=0;i<cursurile.size();i++)
			{
				data[i][0]=Integer.toString(cursurile.get(i).getIdCourse());
				data[i][1]=Integer.toString(cursurile.get(i).getAdministrator().getId());
				data[i][2]=cursurile.get(i).getAdministrator().getNume()+" "+cursurile.get(i).getAdministrator().getPrenume();
				data[i][3]=cursurile.get(i).getNume();
				data[i][4]=Integer.toString(cursurile.get(i).getCredit());
			}
			
			JTable table = new JTable(data,columnNames);
			
			JScrollPane sp = new JScrollPane(table);
			table.setVisible(true);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(50);
			table.getColumnModel().getColumn(2).setPreferredWidth(140);
			table.getColumnModel().getColumn(3).setPreferredWidth(160);
			
			studentProfileView.panel_center.add(sp,"cell 0 1");
			
			JLabel lbldatestart = new JLabel("Start date(dd-mm-yyyy): ");
			studentProfileView.panel_center.add(lbldatestart, "cell 0 2,alignx trailing");
			
			JTextField textField_start = new JTextField();
			studentProfileView.panel_center.add(textField_start, "cell 0 2,growx");
			textField_start.setColumns(20);
			
			JLabel lbldatefinish = new JLabel("Finish date(dd-mm-yyyy): ");
			studentProfileView.panel_center.add(lbldatefinish, "cell 0 3,alignx trailing");
			
			JTextField textField_finish = new JTextField();
			studentProfileView.panel_center.add(textField_finish, "cell 0 3,growx");
			textField_start.setColumns(20);
			
			JButton add = new JButton("Enrolment");
			studentProfileView.panel_center.add(add,"cell 0 4");
			
			add.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					int row = table.getSelectedRow();
					
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date date;
					try {
						date = sdf1.parse(textField_start.getText());
						Date startDate=new java.sql.Date(date.getTime());
						date = sdf1.parse(textField_finish.getText());
						Date finishDate=new java.sql.Date(date.getTime());
					
						Enrolment enrolment = new Enrolment(studentModel.getStudent(),cursurile.get(row),startDate,finishDate,-1);
						
						if(enrolmentService.makeEnrolment(enrolment)!=null)
						{
							JOptionPane.showMessageDialog(null, "Succes!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Error", "ERROR!", JOptionPane.ERROR_MESSAGE);
						}			
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
		}
	}
	class StudentProfileView_Grades implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			studentProfileView.panel_center.removeAll();
			studentProfileView.panel_center.updateUI();
			
			List<Enrolment> enrolments = enrolmentService.getAllByIdStudent(studentModel.getStudent().getIdStudent());
			
			String[] columnNames = {"Nume disciplina","Credit","Start Date","Finish Date","Nota"};
			
			String[][] data = new String[enrolments.size()][5];
			
			for (int i=0;i<enrolments.size();i++)
			{
				data[i][0]=(enrolments.get(i).getCourse().getNume());
				data[i][1]=Integer.toString(enrolments.get(i).getCourse().getCredit());
				data[i][2]=enrolments.get(i).getStartDate().toString();
				data[i][3]=enrolments.get(i).getFinishDate().toString();
				int nota = enrolments.get(i).getNota();
				if(nota==-1)
				{
					data[i][4]="neterminat";
				}
				else
				{
					data[i][4]=Integer.toString(nota);
				}
				
			}
			
			JTable table = new JTable(data,columnNames);
			
			JScrollPane sp = new JScrollPane(table);
			table.setVisible(true);
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(180);
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			
			studentProfileView.panel_center.add(sp,"cell 0 1");
		}
		
	}
	class StudentProfileView_Logout implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			studentProfileView.setVisible(false);
			studentProfileView = new StudentProfile();
			studentProfileView.addButtonViewProfileListener(new StudentProfileView_ButtonViewProfile());
			studentProfileView.addButtonUpdateProfileListener(new StudentProfileView_ButtonUpdateProfile());
			studentProfileView.addButtonDeleteProfileListener(new StudentProfileView_ButtonDeleteProfile());
			studentProfileView.addButtonEnrolmentsListener(new StudentPorfileView_Enrolments());
			studentProfileView.addButtonGradesListener(new StudentProfileView_Grades());
			studentProfileView.addButtonLogoutListener(new StudentProfileView_Logout());
			homeView.setVisible(true);
		}
		
	}
	////////////////////////////////////////////////////////////Home CLASS///////////////////////////////////////////////////////
	class HomeView_BtnLoginListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			List<String> info = homeView.getTextFieldInfo();
			String username = info.get(0);
			String password = info.get(1);
			
			Student student = studentService.getByUsername(username);
			
			if(student!=null)
			{
				if(student.getPassword().equals(password))
				{
					JOptionPane.showMessageDialog(null, "Welcome, "+student.getNume()+" "+student.getPrenume()+" - student", "Welcome", JOptionPane.INFORMATION_MESSAGE);
					studentModel.setStudent(student);
					homeView.setVisible(false);
					studentProfileView.setVisible(true);	
					studentProfileView.setWelcomeText(student.getNume()+ " "+student.getPrenume());
					studentProfileView.panel_center.removeAll();
					studentProfileView.panel_center.updateUI();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Parola incorecta!", "Password incorrect", JOptionPane.ERROR_MESSAGE);
				}							
			}
			else
			{
				Administrator administrator = administratorService.getByUsername(username);
				if(administrator == null)
				{
					JOptionPane.showMessageDialog(null, "Username inexistent!", "Not found", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					if(administrator.getPassword().equals(password))
					{						
						JOptionPane.showMessageDialog(null, "Welcome, "+administrator.getNume()+" "+administrator.getPrenume()+" - administrator", "Welcome", JOptionPane.INFORMATION_MESSAGE);
						administratorModel.setAdministrator(administrator);
						homeView.setVisible(false);
						administratorProfileView.setVisible(true);
						administratorProfileView.setWelcomeText(administrator.getNume()+ " " +administrator.getPrenume());
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Parola incorecta!", "Password incorrect", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			
		}
		
	}
	class HomeView_BtnNewAccountListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			homeView.setVisible(false);
			newAccountView.setVisible(true);
		}
		
	}
	
	////////////////////////////////////////////////////////////NewAccountView CLASS///////////////////////////////////////////////////////
	class NewAccountView_BtnRegisterListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String radio = newAccountView.checkRadioButton();
			if(radio.equals("STUDENT"))
			{
				try {
					Student student = newAccountView.getStudentInfo();
					register.validate(student);
					int id = studentService.registerStudent(student);
					JOptionPane.showMessageDialog(null, "Account created, id:"+id);
					newAccountView.setVisible(false);
					homeView.setVisible(true);
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
					try {
						Administrator admin = newAccountView.getAdminInfo();
						register.validate(admin);
						int id = administratorService.registerAdministrator(admin);
						JOptionPane.showMessageDialog(null, "Account created, id:"+id);
						newAccountView.setVisible(false);
						homeView.setVisible(true);
					}
					catch(IllegalArgumentException e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Select a Student or Administrator");
				}
			}
			
			
		}
		
	}
	class NewAccountView_ButtonCloseListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			newAccountView.setVisible(false);
			homeView.setVisible(true);
		}
	}
}
