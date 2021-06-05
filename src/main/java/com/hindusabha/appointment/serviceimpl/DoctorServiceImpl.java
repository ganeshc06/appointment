package com.hindusabha.appointment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hindusabha.appointment.dto.DoctorSchedule;
import com.hindusabha.appointment.repository.DoctorRepository;
import com.hindusabha.appointment.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public int addDoctor(DoctorSchedule doctorSchedule) {
		return doctorRepository.addDoctor(doctorSchedule);
	}

	@Override
	public int checkDoctorExists(DoctorSchedule doctorSchedule) {
		return doctorRepository.checkDoctorExists(doctorSchedule);
	}

	@Override
	public List<DoctorSchedule> fetchDoctorsSchedule(String departmentId) {
		return doctorRepository.fetchDoctorsSchedule(departmentId);
	}

	@Override
	public List<DoctorSchedule> fetchAllDoctors() {
		return doctorRepository.fetchAllDoctors();
	}

	@Override
	public String fetchDoctorNameById(String doctorId) {
		return doctorRepository.fetchDoctorNameById(doctorId);
	}

}
