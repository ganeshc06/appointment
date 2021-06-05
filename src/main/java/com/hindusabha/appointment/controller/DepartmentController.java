package com.hindusabha.appointment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorDepartmentMapping;
import com.hindusabha.appointment.service.DepartmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class DepartmentController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/add-department/{department-name}")
	public ResponseEntity<String> addDepartment(@PathVariable("department-name") String departmentName, HttpServletRequest request) {
		
		int checkDepartmentExists = departmentService.checkDepartmentExists(departmentName);

		if (checkDepartmentExists == 0) {
			int inserted = departmentService.addDepartment(departmentName,"ganeshc");
			if (inserted == 1) {
				return new ResponseEntity<>("Department saved successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Error saving department data", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Department already exists", HttpStatus.OK);
		}
	}
	
	@GetMapping("/fetch-department")
	public ResponseEntity<List<Department>> fetchDepartment(HttpServletRequest request) {
		List<Department> allDepartments = departmentService.fetchAllDeaprtments();
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	
	@PostMapping("/save-mapping")
	public ResponseEntity<String> saveAppointment(@RequestBody List<DoctorDepartmentMapping> mappingList, HttpServletRequest request) {
		departmentService.deleteMappingByDepartmentId(String.valueOf(mappingList.get(0).getDepartmentId()));
		int[] insertProductScorBatch = departmentService.insertMappingBatch(mappingList);
		return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
	}
	
	@GetMapping("/fetch-mapping-by-department/{departmentId}")
	public ResponseEntity<List<DoctorDepartmentMapping>> fetchMappingByDepartment(@PathVariable("departmentId") String departmentId,HttpServletRequest request) {
		List<DoctorDepartmentMapping> mappings = departmentService.fetchMappingByDepartment(departmentId);
		return new ResponseEntity<>(mappings, HttpStatus.OK);
	}
}
