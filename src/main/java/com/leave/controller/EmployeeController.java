package com.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leave.request.EmployeeRequest;
import com.leave.response.EmployeeResonse;
import com.leave.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api/emp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeResonse>> getAllEmployees() {
		List<EmployeeResonse> responses = employeeService.getAllEmployees();
		return ResponseEntity.ok(responses);
	}
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<EmployeeResonse> saveEmployee(@RequestBody EmployeeRequest employeeRequest) {
		EmployeeResonse response = employeeService.saveEmployee(employeeRequest);
		return ResponseEntity.ok(response);
	}
}
