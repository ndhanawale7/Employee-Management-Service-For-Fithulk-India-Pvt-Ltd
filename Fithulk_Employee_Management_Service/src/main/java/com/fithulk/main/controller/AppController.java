package com.fithulk.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fithulk.main.dao.MyRepository;
import com.fithulk.main.model.Employee;
import com.fithulk.main.service.MyService;

@Controller
public class AppController {

	@Autowired
	private MyService service;
	
	//To Display List of Employees
	@GetMapping(value="/")
	public String homePage(@ModelAttribute Employee e,Model m) 
	{
		m.addAttribute("listEmployees",service.getAllEmployees());
		return "index";
	}
	
	//For binding form data
	@GetMapping(value="/showNewEmployeeForm")
	public String showNewEmployeeForm(@ModelAttribute Employee e,Model m) 
	{
		Employee employee=new Employee();
		m.addAttribute("Employee",employee);
		return "new_employee" ;
	}
	
	//save employee
	@PostMapping(value="/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee employee,Model m) 
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	
	//get employee from service
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") int id,Model m) 
	{
		Employee employee = service.getEmployeeById(id);
		m.addAttribute("employee", employee);
		return "update_employee";
	}
	
	//Delete perticular employee
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value="id") int id,Model m) 
	   {
		service.deleteEmployeeById(id);
		return "redirect:/";
		}
}


