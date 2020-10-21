package com.redfern.springbootpostgresql1.model;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	//MEMBER VARIABLES
	@Id
	@GeneratedValue(generator="employees_id_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(
			name = "employees_id_seq",
			sequenceName="employees_id_seq",
			allocationSize=1
			)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="employee", cascade=CascadeType.ALL, fetch=FetchType.EAGER, targetEntity=Pet.class)
	private List<Pet> pets;
	
	@ManyToMany
	private List<Project> projects;

	//CONSTRUCTORS
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Employee() {
		super();
	}

	//GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pet> getPets() {
		if(this.pets == null) {
			this.pets = new ArrayList<Pet>();
		}
		return this.pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	
//	public void addPet(Pet pet) {
//		getPets().add(pet);
//	}

}