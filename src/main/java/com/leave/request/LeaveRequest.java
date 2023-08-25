package com.leave.request;

import java.time.LocalDate;

import com.leave.entities.LeaveType;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class LeaveRequest {
	private EmployeeRequest employeeRequest;
	private LocalDate leaveStartDate;
	private LocalDate leaveEndDate;
	private LeaveType leaveType;
	private String leaveReason;

}
