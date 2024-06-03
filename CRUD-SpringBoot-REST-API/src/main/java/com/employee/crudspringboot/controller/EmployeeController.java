package com.employee.crudspringboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.employee.crudspringboot.entity.Employee;
import com.employee.crudspringboot.service.EmployeeService;

@Controller
//@RequestMapping("/admin")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String home(Model model) {
		System.out.println("Entering...Home");
		return "admin/employees/employees-home.html";
	}
	
	@GetMapping("/employee-home")
	public String employeeHome(Model model) {
		//System.out.println("Entering employee home...");
		return "admin/employees/employees-home.html";
	}
	
	@GetMapping("/employee-edit-form/{employeeId}")
	public ModelAndView employeeEdit(Model model, @PathVariable("employeeId") long id) {
		ModelAndView mv = new ModelAndView();
		//System.out.println("Entering Employee Edit");
		
		if(id != 0) {
			
			//fetch the employee details from db
			Optional<Employee> employee = employeeService.getEmployeeById(id);
			if(employee.isPresent()) {
				Employee empObj = employee.get();
				model.addAttribute("employee", empObj);
				model.addAttribute("id", id);
			}else {
				System.out.println("Employee is not present!");
			}
			
		}else {
			System.out.println("Employee Id not found! Please Check properly");
		}
		
		
		mv.setViewName("admin/employees/employees-edit-form");
		return mv;
	}
	
	@GetMapping("/employee-add-form")
	public ModelAndView employeeAddForm(Model model) {
		ModelAndView mv = new ModelAndView();
		System.out.println("Entering Employee Add Form");
		mv.setViewName("admin/employees/employees-add-form");
		return mv;
	}
	
	

}
