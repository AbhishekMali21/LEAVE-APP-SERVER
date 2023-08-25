package com.leave.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_record")
@Data
@NoArgsConstructor
public class Employee {
	@Id
	private String empId;
	private String empName;
}
