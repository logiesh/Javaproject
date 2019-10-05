package com.visitor.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.visitor.model.Employee;
@Repository
public interface EmployeeJpaRepository {
	Employee findByEmployeeId(long employeeId);
	List<Employee> findByname(String name);
	List<Employee> findAll();
}
