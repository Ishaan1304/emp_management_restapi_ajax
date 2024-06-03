package com.employee.crudspringboot.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.crudspringboot.entity.Employee;
import com.employee.crudspringboot.repository.EmployeeRepository;
import com.employee.crudspringboot.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee newEmployee = new Employee();
		
		Optional<Employee> oldEmployee = employeeRepository.findById(id);
		if(oldEmployee.isPresent()) {
			oldEmployee.get().setName(employee.getName());
			oldEmployee.get().setEmail(employee.getEmail());
			oldEmployee.get().setContact(employee.getContact());
			oldEmployee.get().setAddress(employee.getAddress());
			oldEmployee.get().setDepartment(employee.getDepartment());
			oldEmployee.get().setCreatedAt(new Date());
			
			newEmployee = employeeRepository.save(oldEmployee.get());
			
			
			
		}
		
		return newEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

}
