package com.leave.response;

import java.time.LocalDate;

import com.leave.entities.LeaveType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LeaveResponse {
	
    private EmployeeResonse employeeResonse;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private LeaveType leaveType;
    private String leaveReason;

}
