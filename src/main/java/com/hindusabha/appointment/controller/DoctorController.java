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

import com.hindusabha.appointment.dto.DoctorSchedule;
import com.hindusabha.appointment.service.DoctorService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class DoctorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorService doctorService;

	@PostMapping("/add-doctor")
	public ResponseEntity<String> addDoctor(@RequestBody DoctorSchedule doctorSchedule, HttpServletRequest request) {

		doctorSchedule.setInsertId("ganeshc");
		doctorSchedule.setUpdateId("ganeshc");
		LOGGER.info("Doctor Schedule = {}", doctorSchedule.toString());

		int checkDoctorExists = doctorService.checkDoctorExists(doctorSchedule);

		if (checkDoctorExists == 0) {
			int inserted = doctorService.addDoctor(doctorSchedule);
			if (inserted == 1) {
				return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Error saving doctor data", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Doctor already exists", HttpStatus.OK);
		}

	}
	
	@GetMapping("/fetch-doctor-schedule/{department-id}")
	public ResponseEntity<List<DoctorSchedule>> fetchDoctorSchedule(@PathVariable("department-id") String departmentId){
		List<DoctorSchedule> doctorsSchedule = doctorService.fetchDoctorsSchedule(departmentId);
		return new ResponseEntity<>(doctorsSchedule, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-doctor")
	public ResponseEntity<List<DoctorSchedule>> fetchDoctor(HttpServletRequest request) {
		List<DoctorSchedule> allDoctors = doctorService.fetchAllDoctors();
		return new ResponseEntity<>(allDoctors, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-doctor-name/{doctor-id}")
	public ResponseEntity<String> fetchDoctorNameById(@PathVariable("doctor-id") String doctorId){
		String doctorName = doctorService.fetchDoctorNameById(doctorId);
		return new ResponseEntity<>(doctorName, HttpStatus.OK);
	}

}
