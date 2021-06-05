package com.hindusabha.appointment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorDepartmentMapping;
import com.hindusabha.appointment.dto.DoctorSchedule;
import com.hindusabha.appointment.repository.DepartmentRepository;
import com.hindusabha.appointment.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public int addDepartment(String departmentName, String userName) {
		return departmentRepository.addDepartment(departmentName, userName);
	}

	@Override
	public Department fetchDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department fetchDepartmentById(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int checkDepartmentExists(String departmentName) {
		return departmentRepository.checkDepartmentExists(departmentName);
	}

	@Override
	public List<Department> fetchAllDeaprtments() {
		return departmentRepository.fetchAllDepartments();
	}

	@Override
	public int[] insertMappingBatch(List<DoctorDepartmentMapping> mappingList) {
		return departmentRepository.insertMappingBatch(mappingList);
	}

	@Override
	public List<DoctorDepartmentMapping> fetchMappingByDepartment(String departmentId) {
		return departmentRepository.fetchMappingByDepartment(departmentId);
	}

	@Override
	public int deleteMappingByDepartmentId(String departmentId) {
		return departmentRepository.deleteMappingByDepartmentId(departmentId);
	}

}
