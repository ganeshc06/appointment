package com.hindusabha.appointment.repository;

import java.util.List;

import com.hindusabha.appointment.dto.Appointment;
import com.hindusabha.appointment.dto.Statistics;

public interface AppointmentRepository {

	int checkAppointmentExists(Appointment appointment);
	
	int addAppointment(Appointment appointment);
	
	List<Appointment> fetchAllAppointments();

	Statistics fetchStatistics();

	int updateAppointmentStatus(String appointmentId);
}
