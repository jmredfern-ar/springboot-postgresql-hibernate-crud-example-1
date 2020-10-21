package com.redfern.springbootpostgresql1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redfern.springbootpostgresql1.model.Project;
import com.redfern.springbootpostgresql1.repository.ProjectRepository;

@Service
public class ProjectService {

		@Autowired
		private ProjectRepository projectRepository;
		
		public List<Project> findAll() {
			List<Project> projects = projectRepository.findAll();
			return projects;
		}
}
