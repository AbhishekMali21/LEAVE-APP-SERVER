package com.leave.service;

import java.util.List;

import com.leave.request.LeaveRequest;
import com.leave.response.LeaveResponse;

public interface LeaveService {

	LeaveResponse saveLeave(LeaveRequest leaveRequest);

	List<LeaveResponse> getAllLeaves();

	List<LeaveResponse> getLeavesByEmployeeId(String empId);

}
