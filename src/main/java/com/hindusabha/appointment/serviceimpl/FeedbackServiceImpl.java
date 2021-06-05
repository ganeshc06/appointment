package com.hindusabha.appointment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hindusabha.appointment.dto.Feedback;
import com.hindusabha.appointment.dto.FeedbackStatistics;
import com.hindusabha.appointment.dto.VaccinationFeedback;
import com.hindusabha.appointment.dto.VaccinationStatistics;
import com.hindusabha.appointment.repository.FeedbackRepository;
import com.hindusabha.appointment.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public int saveFeedback(Feedback feedback) {
		return feedbackRepository.saveFeedback(feedback);
	}

	@Override
	public int saveVaccinationFeedback(VaccinationFeedback feedback) {
		return feedbackRepository.saveVaccinationFeedback(feedback);
	}

	@Override
	public List<VaccinationFeedback> fetchVaccinationDetails() {
		return feedbackRepository.fetchVaccinationDetails();
	}

	@Override
	public VaccinationStatistics fetchVaccinationStatistics() {
		return feedbackRepository.fetchVaccinationStatistics();
	}
	
	@Override
	public List<Feedback> fetchIpdDetails() {
		return feedbackRepository.fetchIpdDetails();
	}

	@Override
	public FeedbackStatistics fetchIpdStatistics() {
		return feedbackRepository.fetchIpdStatistics();
	}
}
