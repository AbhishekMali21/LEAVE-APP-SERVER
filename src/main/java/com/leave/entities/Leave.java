package com.leave.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leave_record")
@Data
@NoArgsConstructor
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	private LocalDate leaveStartDate;
	private LocalDate leaveEndDate;

	@Enumerated(EnumType.STRING)
	private LeaveType leaveType;

	private String leaveReason;
	
	private LocalDate appliedDate;
}
