package com.hindusabha.appointment.repository;

import java.util.List;

import com.hindusabha.appointment.dto.DoctorSchedule;

public interface DoctorRepository {

	int addDoctor(DoctorSchedule doctorSchedule);
	
	int checkDoctorExists(DoctorSchedule doctorSchedule);
	
	List<DoctorSchedule> fetchDoctorsSchedule(String departmentId);

	List<DoctorSchedule> fetchAllDoctors();

	String fetchDoctorNameById(String doctorId);
}
