package com.leave.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leave.entities.Employee;
import com.leave.entities.Leave;
import com.leave.repository.EmployeeRepository;
import com.leave.repository.LeaveRepository;
import com.leave.request.LeaveRequest;
import com.leave.response.EmployeeResonse;
import com.leave.response.LeaveResponse;
import com.leave.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveRepository leaveRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public LeaveResponse saveLeave(LeaveRequest leaveRequest) {
		Employee employee = employeeRepository.findByEmpId(leaveRequest.getEmployeeRequest().getEmpId());

		Leave leave = new Leave();
		leave.setEmployee(employee);
		leave.setLeaveStartDate(leaveRequest.getLeaveStartDate());
		leave.setLeaveEndDate(leaveRequest.getLeaveEndDate());
		leave.setLeaveType(leaveRequest.getLeaveType());
		leave.setLeaveReason(leaveRequest.getLeaveReason());

		leaveRepository.save(leave);

		return convertLeaveToResponse(leave);
	}

	@Override
	public List<LeaveResponse> getAllLeaves() {
		List<Leave> leaves = leaveRepository.findAll();
		return leaves.stream().map(this::convertLeaveToResponse).collect(Collectors.toList());
	}

	@Override
	public List<LeaveResponse> getLeavesByEmployeeId(String empId) {
		List<Leave> leaves = leaveRepository.findByEmployee_EmpId(empId);
		return leaves.stream().map(this::convertLeaveToResponse).collect(Collectors.toList());
	}

	private LeaveResponse convertLeaveToResponse(Leave leave) {
		LeaveResponse response = new LeaveResponse();
		if (leave.getEmployee() != null) {
			EmployeeResonse employeeResonse = new EmployeeResonse();
			employeeResonse.setEmpId(leave.getEmployee().getEmpId());
			employeeResonse.setEmpName(leave.getEmployee().getEmpName());
			response.setEmployeeResonse(employeeResonse);
		}
		response.setLeaveStartDate(leave.getLeaveStartDate());
		response.setLeaveEndDate(leave.getLeaveEndDate());
		response.setLeaveType(leave.getLeaveType());
		response.setLeaveReason(leave.getLeaveReason());
		return response;
	}
}
