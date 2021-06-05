package com.hindusabha.appointment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hindusabha.appointment.dto.Appointment;
import com.hindusabha.appointment.dto.Statistics;
import com.hindusabha.appointment.repository.AppointmentRepository;
import com.hindusabha.appointment.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Override
	public int checkAppointmentExists(Appointment appointment) {
		return appointmentRepository.checkAppointmentExists(appointment);
	}

	@Override
	public int addAppointment(Appointment appointment) {
		return appointmentRepository.addAppointment(appointment);
	}

	@Override
	public List<Appointment> fetchAllAppointments() {
		return appointmentRepository.fetchAllAppointments();
	}

	@Override
	public Statistics fetchStatistics() {
		return appointmentRepository.fetchStatistics();
	}

	@Override
	public int updateAppointmentStatus(String appointmentId) {
		return appointmentRepository.updateAppointmentStatus(appointmentId);
	}

}
