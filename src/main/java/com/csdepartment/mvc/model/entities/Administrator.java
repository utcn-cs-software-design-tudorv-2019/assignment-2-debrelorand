package com.csdepartment.mvc.model.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Administrator {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idadministrator",nullable=false)
	private int idadministrator;
	
	@Column(name = "nume", nullable = false)
	private String nume;
	
	@Column(name = "prenume", nullable = false)
	private String prenume;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "cnp", nullable = false)
	private String cnp;
	
	@Column(name = "adresa", nullable = false)
	private String adresa;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "catedra", nullable = false)
	private String catedra;
	
	@OneToMany(mappedBy="administrator")
	private List<Course> cursurile;
	
	public Administrator(String nume, String prenume, String username, String password, String cnp, String adresa,
			String email, String catedra) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.username = username;
		this.password = password;
		this.cnp = cnp;
		this.adresa = adresa;
		this.email = email;
		this.catedra = catedra;
	}

	public Administrator() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return idadministrator;
	}

	public void setId(int id) {
		this.idadministrator = id;
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

	public String getCatedra() {
		return catedra;
	}

	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}

	@Override
	public String toString() {
		return "Administrator [idadministrator=" + idadministrator + ", nume=" + nume + ", prenume=" + prenume
				+ ", username=" + username + ", password=" + password + ", cnp=" + cnp + ", adresa=" + adresa
				+ ", email=" + email + ", catedra=" + catedra + ", curs=" +cursurile + "]";
	}
	
	
}
