package com.hindusabha.appointment.repository;

import java.util.List;

import com.hindusabha.appointment.dto.Feedback;
import com.hindusabha.appointment.dto.FeedbackStatistics;
import com.hindusabha.appointment.dto.VaccinationFeedback;
import com.hindusabha.appointment.dto.VaccinationStatistics;

public interface FeedbackRepository {

	int saveFeedback(Feedback feedback);

	int saveVaccinationFeedback(VaccinationFeedback feedback);

	List<VaccinationFeedback> fetchVaccinationDetails();

	VaccinationStatistics fetchVaccinationStatistics();
	
	List<Feedback> fetchIpdDetails();
	
	FeedbackStatistics fetchIpdStatistics();

}
