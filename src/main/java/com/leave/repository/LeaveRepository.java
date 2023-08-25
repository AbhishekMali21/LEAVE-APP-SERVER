package com.leave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leave.entities.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Integer> {
	List<Leave> findByEmployee_EmpId(String empId);
}
