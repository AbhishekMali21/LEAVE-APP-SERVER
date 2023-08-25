package com.leave.entities;

public enum LeaveType {
	PL("Paid Leave"), LWP("Leave Without Pay"), SL("Sick Leave"), CL("Casual Leave"), ML("Maternity Leave"),
	WL("Wedding Leave"), HDL("Holiday");

	private final String displayName;

	LeaveType(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}
}
