package com.leave.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.entities.Employee;
import com.leave.repository.EmployeeRepository;
import com.leave.request.EmployeeRequest;
import com.leave.response.EmployeeResonse;
import com.leave.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeResonse> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(this::convertEmployeeToResponse).collect(Collectors.toList());
	}

	@Override
	public EmployeeResonse saveEmployee(EmployeeRequest employeeRequest) {

		Employee employee = new Employee();
		employee.setEmpId(employeeRequest.getEmpId());
		employee.setEmpName(employeeRequest.getEmpName());

		employeeRepository.save(employee);
		return convertEmployeeToResponse(employee);
	}

	private EmployeeResonse convertEmployeeToResponse(Employee employee) {
		EmployeeResonse response = new EmployeeResonse();
		if (employee.getEmpId() != null && employee.getEmpName() != null) {
			response.setEmpId(employee.getEmpId());
			response.setEmpName(employee.getEmpName());
		}
		return response;
	}

}
