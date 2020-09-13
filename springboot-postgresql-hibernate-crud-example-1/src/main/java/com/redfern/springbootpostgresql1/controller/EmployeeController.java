package com.redfern.springbootpostgresql1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.redfern.springbootpostgresql1.model.Employee;
import com.redfern.springbootpostgresql1.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
//	@Value("${msg.title}")
//	private String title = "test"; //TODO not sure what this does...
	
	@GetMapping(value = {"/", "index"})
	public String index(Model model) {
//		model.addAttribute("title", title);
		return "index";
	}
	
	@GetMapping("/employees")
	public String getEmployees(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employee-list";
	}
	
	@GetMapping(value = {"/employees/add"})
	public String showAddEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("add", true);
		model.addAttribute("employee", employee);
		return "employee-edit";
	}
	
}

