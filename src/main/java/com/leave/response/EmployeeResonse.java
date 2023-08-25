package com.leave.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EmployeeResonse {

	private String empId;
	private String empName;

}
