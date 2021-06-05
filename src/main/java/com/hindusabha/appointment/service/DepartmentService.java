package com.hindusabha.appointment.service;

import java.util.List;

import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorDepartmentMapping;

public interface DepartmentService {

	int addDepartment(String departmentName, String username);
	
	Department fetchDepartment();
	
	Department fetchDepartmentById(String departmentId);
	
	Department fetchDepartmentByName(String departmentName);

	int checkDepartmentExists(String departmentName);

	List<Department> fetchAllDeaprtments();

	int[] insertMappingBatch(List<DoctorDepartmentMapping> mappingList);

	List<DoctorDepartmentMapping> fetchMappingByDepartment(String departmentId);
	
	int deleteMappingByDepartmentId(String departmentId);
}
