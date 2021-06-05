package com.hindusabha.appointment.repository;

import java.util.List;

import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorDepartmentMapping;

public interface DepartmentRepository {

	int addDepartment(String departmentName, String userName);

	Department fetchDepartment();

	Department fetchDepartmentById(String departmentId);
	
	Department fetchDepartmentByName(String departmentName);

	int checkDepartmentExists(String departmentName);

	List<Department> fetchAllDepartments();

	int[] insertMappingBatch(List<DoctorDepartmentMapping> mappingList);

	List<DoctorDepartmentMapping> fetchMappingByDepartment(String departmentId);

	int deleteMappingByDepartmentId(String departmentId);
}
