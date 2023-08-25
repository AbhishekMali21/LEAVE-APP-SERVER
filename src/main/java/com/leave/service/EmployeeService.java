package com.leave.service;

import java.util.List;

import com.leave.request.EmployeeRequest;
import com.leave.response.EmployeeResonse;

public interface EmployeeService {

	List<EmployeeResonse> getAllEmployees();

	EmployeeResonse saveEmployee(EmployeeRequest employeeRequest);
	
}
