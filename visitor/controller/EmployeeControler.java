package com.visitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.visitor.model.Employee;
import com.visitor.service.EmployeeService;


@RequestMapping("/api")
@RestController
public class EmployeeControler {

	 @Autowired
	 public EmployeeService employeeService;
	 
	 
	 @GetMapping("/employees")
	    public List<Employee> fetchAllEmployees(@RequestParam(value = "fname", required = false) String fname, @RequestParam(value = "fvalue", required = false) String fvalue) {
	        if (StringUtils.isEmpty(fname) || StringUtils.isEmpty(fvalue)) {
	            final List<Employee> employees = employeeService.fetchAllEmployees();
	            return employees;
	        } else {
	            return employeeService.findname(fvalue);
	        }

	    }
	 
	    @GetMapping("/employees/{employeeId}")
	    public Employee findByemployeeId(@PathVariable(value = "employeeId") String employeeId) {
	        return employeeService.fetchByEmployeeId(employeeId);
	    }

	
	  /**
     * This method using edit and Update services.
     *
     * @param profile
     * @return
     */
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody final Employee employee) {
            return employeeService.saveEmployee(employee);
    }

  
	
	
}
