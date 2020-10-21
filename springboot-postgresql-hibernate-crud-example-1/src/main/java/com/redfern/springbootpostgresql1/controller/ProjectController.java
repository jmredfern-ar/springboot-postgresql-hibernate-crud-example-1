package com.redfern.springbootpostgresql1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.redfern.springbootpostgresql1.model.Project;
import com.redfern.springbootpostgresql1.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@GetMapping("/projects")
	public String getProjects(Model model) {
		List<Project> projects = projectService.findAll();
		model.addAttribute("projects", projects);
		return "project-list";
	}
}
