package com.redfern.springbootpostgresql1.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.redfern.springbootpostgresql1.model.Pet;
import com.redfern.springbootpostgresql1.model.Project;

public class EmployeeDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Pet> pets;
	Set<Project> projects = new HashSet<Project>();
}
