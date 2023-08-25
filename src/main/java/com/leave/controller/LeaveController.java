package com.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leave.request.LeaveRequest;
import com.leave.response.LeaveResponse;
import com.leave.service.LeaveService;

@CrossOrigin
@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

	@Autowired
	private LeaveService leaveService;

	@CrossOrigin
	@PostMapping("/save")
	public ResponseEntity<LeaveResponse> saveLeave(@RequestBody LeaveRequest leaveRequest) {
		LeaveResponse response = leaveService.saveLeave(leaveRequest);
		return ResponseEntity.ok(response);
	}

	@CrossOrigin
	@GetMapping("/all")
	public ResponseEntity<List<LeaveResponse>> getAllLeaves() {
		List<LeaveResponse> responses = leaveService.getAllLeaves();
		return ResponseEntity.ok(responses);
	}

	@CrossOrigin
	@GetMapping("/employee/{empId}")
	public ResponseEntity<List<LeaveResponse>> getLeavesByEmployeeId(@PathVariable String empId) {
		List<LeaveResponse> responses = leaveService.getLeavesByEmployeeId(empId);
		return ResponseEntity.ok(responses);
	}
}
