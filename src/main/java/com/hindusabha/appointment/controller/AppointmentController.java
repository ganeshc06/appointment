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

import com.hindusabha.appointment.dto.Appointment;
import com.hindusabha.appointment.dto.Statistics;
import com.hindusabha.appointment.service.AppointmentService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class AppointmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentController.class);
	
	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/save-appointment")
	public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment, HttpServletRequest request) {
		
		LOGGER.info("Appointment Schedule = {}", appointment.toString());

		int checkAppointmentExists = appointmentService.checkAppointmentExists(appointment);
		if (checkAppointmentExists == 0) {
			int inserted = appointmentService.addAppointment(appointment);
			if (inserted == 1) {
				return new ResponseEntity<>("Data saved successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Error saving doctor data", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			return new ResponseEntity<>("Appointment already exists", HttpStatus.OK);
		}
	}
	
	@GetMapping("/fetch-appointment")
	public ResponseEntity<List<Appointment>> fetchAppointment(HttpServletRequest request) {
		List<Appointment> allAppointments = appointmentService.fetchAllAppointments();
		return new ResponseEntity<>(allAppointments, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-statistics")
	public ResponseEntity<Statistics> fetchStatistics(HttpServletRequest request) {
		Statistics statistics = appointmentService.fetchStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	@GetMapping("/updateAppointmentStatus/{appointmentId}")
	public ResponseEntity<String> updateAppointmentStatus(HttpServletRequest request,@PathVariable("appointmentId") String appointmentId) {
		int inserted = appointmentService.updateAppointmentStatus(appointmentId);
		if (inserted == 1) {
			return new ResponseEntity<>("Visiting status updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error updating visiting status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
