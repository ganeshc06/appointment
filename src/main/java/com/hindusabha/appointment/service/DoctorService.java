package com.hindusabha.appointment.service;

import java.util.List;

import com.hindusabha.appointment.dto.DoctorSchedule;

public interface DoctorService {
	
	int addDoctor(DoctorSchedule doctorSchedule);
	
	int checkDoctorExists(DoctorSchedule doctorSchedule);
	
	List<DoctorSchedule> fetchDoctorsSchedule(String departmentId);

	List<DoctorSchedule> fetchAllDoctors();

	String fetchDoctorNameById(String doctorId);
}
