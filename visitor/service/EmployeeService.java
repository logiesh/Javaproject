package com.visitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visitor.model.Employee;
import com.visitor.repository.EmployeeJpaRepository;

@Service
public class EmployeeService {

	public final static int RAMDOM_NUM_SIZE = 20;
    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;
    
    public List<Employee> fetchAllEmployees() {
		final List<Employee> all = employeeJpaRepository.findAll();
		return all;

	}
    


	public List<Employee> findname(String name) {
		
		  return employeeJpaRepository.findByname(name);
	}
	public Employee fetchByEmployeeId(String employeeId) {
		
		return (Employee) employeeJpaRepository.findByEmployeeId(Long.valueOf(employeeId));
	
	}
	
	public EmployeeJpaRepository getEmployeeJpaRepository() {
		return employeeJpaRepository;
	}
	public void setEmployeeJpaRepository(EmployeeJpaRepository employeeJpaRepository) {
		this.employeeJpaRepository = employeeJpaRepository;
	}

	public Employee saveEmployee(Employee employee) {
		return null;
	}

    
    
}
