package com.fithulk.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fithulk.main.dao.MyRepository;
import com.fithulk.main.model.Employee;
import com.fithulk.main.service.MyService;

@Service
public class ServiceImpl implements MyService {
	
	@Autowired
	private MyRepository myrepo;

	@Override
	public List<Employee> getAllEmployees() 
	{
	return myrepo.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) 
	{
		myrepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) 
	{
		
		Optional<Employee> optional = myrepo.findById(id);
        Employee employee=null;
        
        if(optional.isPresent())
        {
        	 employee = optional.get();
        }
        else 
        {
        	throw new RuntimeException("Employee not found for id"+id);
        }
        return employee;
	}

	
	@Override
	public void deleteEmployeeById(int id) 
	{
		myrepo.deleteById(id);
	}
	
	
}
