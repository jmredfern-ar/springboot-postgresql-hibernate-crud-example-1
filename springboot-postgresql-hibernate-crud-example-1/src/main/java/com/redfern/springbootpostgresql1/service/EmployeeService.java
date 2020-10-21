package com.redfern.springbootpostgresql1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.redfern.springbootpostgresql1.model.Employee;
import com.redfern.springbootpostgresql1.model.Project;
import com.redfern.springbootpostgresql1.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	private boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}
	
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return employees;
	}
		
	public Employee findById(Long id) throws Exception {
		Employee employee = employeeRepository.findById(id).orElse(null);
		if(employee == null) {
			throw new Exception("Cannot find Employee with id: " + id);
		}
		else
			return employee;
	}
	
	public Employee save(Employee employee) throws Exception {
		if(!StringUtils.isEmpty(employee.getFirstName())) {
			if(employee.getId() != null && existsById(employee.getId())) {
				throw new Exception("Contact with id: " + employee.getId() +
						" already exists");
			}
			return employeeRepository.save(employee);
		} else {
			Exception e = new Exception("Failed to save employee");
			throw e; 
		}
	}

	public void update(Employee employee) throws Exception {
		if(!StringUtils.isEmpty(employee.getFirstName())) {
			if(!existsById(employee.getId())) {
				throw new Exception("Cannot find Employee with id: " + employee.getId());
			}
			
			employeeRepository.save(employee);
			
		} else {
			Exception e = new Exception("Failed to save employee");
			throw e;
		}
	}
	
	public void deleteById(Long id) throws Exception {
		if(!existsById(id)) {
			throw new Exception("Cannot find employee with id: " + id);
		} else {
			employeeRepository.deleteById(id);
		}
 	}
	
	public Long count() {
		return employeeRepository.count();
	}
}


