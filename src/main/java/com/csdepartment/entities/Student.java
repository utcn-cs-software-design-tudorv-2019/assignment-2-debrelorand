package com.csdepartment.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idstudent",nullable=false)
	private int idstudent;
	
	@Column(name="nume",nullable=false,length=45)
	private String nume;
	
	@Column(name="prenume",nullable=false,length=45)
	private String prenume;
	
	@Column(name="username",nullable=false,length=45)
	private String username;
	
	@Column(name="password",nullable=false,length=70)
	private String password;
	
	@Column(name="cnp",nullable=false,length=13)
	private String cnp;
	
	@Column(name="adresa",nullable=false,length=120)
	private String adresa;
	
	@Column(name="email",nullable=false,length=100)
	private String email;
	
	@Column(name="grupa",nullable=false,length=45)
	private String grupa;
	
	@OneToMany(mappedBy="student",fetch=FetchType.EAGER)
	private List<Enrolment> enrolment;
	
	public Student(String nume, String prenume, String username, String password, String cnp,
			String adresa, String email, String grupa) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.username = username;
		this.password = password;
		this.cnp = cnp;
		this.adresa = adresa;
		this.email = email;
		this.grupa = grupa;
		//this.enrolments=new ArrayList<Enrolment>();
	}

	public Student()
	{
		super();
	}
	
	public int getIdStudent() {
		return idstudent;
	}

	public void setIdStudent(int idStudent) {
		this.idstudent = idStudent;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public List<Enrolment> getEnrolment() {
		return enrolment;
	}

	public void setEnrolment(List<Enrolment> enrolments) {
		this.enrolment = enrolments;
	}
	
	public void addEnrolments(Enrolment enrolment)
	{
		this.enrolment.add(enrolment);
	}

	@Override
	public String toString() {
		return "Student [idStudent=" + idstudent + ", nume=" + nume + ", prenume=" + prenume + ", username=" + username
				+ ", password=" + password + ", cnp=" + cnp + ", adresa=" + adresa + ", email=" + email + ", grupa="
				+ grupa + ", enrolments=" + "]";
	}
	
	
}
