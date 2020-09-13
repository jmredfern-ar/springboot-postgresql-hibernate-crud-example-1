package com.redfern.springbootpostgresql1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.redfern.springbootpostgresql1.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
