package com.fithulk.main.service;

import java.util.List;
import com.fithulk.main.model.Employee;

public interface MyService {

List<Employee> getAllEmployees();

void saveEmployee(Employee employee);

Employee getEmployeeById(int id);

void deleteEmployeeById(int id);


	
}
