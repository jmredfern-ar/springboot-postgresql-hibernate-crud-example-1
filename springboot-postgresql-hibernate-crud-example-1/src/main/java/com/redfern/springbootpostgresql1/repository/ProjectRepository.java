package com.redfern.springbootpostgresql1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redfern.springbootpostgresql1.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
	
//	public Project findByName(String projectName);

}
