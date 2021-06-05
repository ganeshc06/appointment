package com.hindusabha.appointment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hindusabha.appointment.dto.Feedback;
import com.hindusabha.appointment.dto.FeedbackStatistics;
import com.hindusabha.appointment.dto.VaccinationFeedback;
import com.hindusabha.appointment.dto.VaccinationStatistics;
import com.hindusabha.appointment.service.FeedbackService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;

	@PostMapping("/save-feedback")
	public ResponseEntity<String> saveFeedback(@RequestBody Feedback feedback){
		String msg = "";
		int saveFeedbackStatus = feedbackService.saveFeedback(feedback);
		if(saveFeedbackStatus > 0) {
			msg = "Feedback inserted successfully";
		}else {
			msg = "Feedback not saved";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@PostMapping("/save-vaccine-feedback")
	public ResponseEntity<String> saveFeedback(@RequestBody VaccinationFeedback feedback){
		String msg = "";
		int saveFeedbackStatus = feedbackService.saveVaccinationFeedback(feedback);
		if(saveFeedbackStatus > 0) {
			msg = "Feedback inserted successfully";
		}else {
			msg = "Feedback not saved";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/fetch-vaccination-details")
	public ResponseEntity<List<VaccinationFeedback>> fetchVaccinationDetails(HttpServletRequest request) {
		List<VaccinationFeedback> allAppointments = feedbackService.fetchVaccinationDetails();
		return new ResponseEntity<>(allAppointments, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-vaccination-statistics")
	public ResponseEntity<VaccinationStatistics> fetchVaccinationStatistics(HttpServletRequest request) {
		VaccinationStatistics statistics = feedbackService.fetchVaccinationStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-ipd-details")
	public ResponseEntity<List<Feedback>> fetchIpdDetails(HttpServletRequest request) {
		List<Feedback> ipdReports = feedbackService.fetchIpdDetails();
		return new ResponseEntity<>(ipdReports, HttpStatus.OK);
	}
	
	@GetMapping("/fetch-ipd-statistics")
	public ResponseEntity<FeedbackStatistics> fetchIpdStatistics(HttpServletRequest request) {
		FeedbackStatistics statistics = feedbackService.fetchIpdStatistics();
		return new ResponseEntity<>(statistics, HttpStatus.OK);
	}
}
