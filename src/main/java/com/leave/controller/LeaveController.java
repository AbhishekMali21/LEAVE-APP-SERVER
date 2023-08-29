package com.leave.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

	@CrossOrigin
	@GetMapping("/employee/{empId}/download-excel")
	public ResponseEntity<byte[]> downloadExcelByEmployeeId(@PathVariable String empId) {
		List<LeaveResponse> leaveResponses = leaveService.getLeavesByEmployeeId(empId);

		Workbook workbook = new XSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Leave Records");

		Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);
		headerRow.createCell(0).setCellValue("Leave Start Date");
		headerRow.createCell(1).setCellValue("Leave End Date");
		headerRow.createCell(2).setCellValue("Leave Type");
		headerRow.createCell(3).setCellValue("Leave Reason");

		for (int i = 0; i < leaveResponses.size(); i++) {
			LeaveResponse leaveResponse = leaveResponses.get(i);
			Row dataRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(i + 1);
			dataRow.createCell(0).setCellValue(leaveResponse.getLeaveStartDate());
			dataRow.createCell(1).setCellValue(leaveResponse.getLeaveEndDate());
			dataRow.createCell(2).setCellValue(leaveResponse.getLeaveType().toString());
			dataRow.createCell(3).setCellValue(leaveResponse.getLeaveReason());
		}

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "leave_records.xlsx");

		return new ResponseEntity<>(outputStream.toByteArray(), headers, org.springframework.http.HttpStatus.OK);
	}
}
