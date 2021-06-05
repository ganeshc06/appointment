package com.hindusabha.appointment.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hindusabha.appointment.dto.Appointment;
import com.hindusabha.appointment.dto.Statistics;
import com.hindusabha.appointment.repository.AppointmentRepository;
import com.hindusabha.appointment.service.DoctorService;
import com.hindusabha.appointment.sms.Sender;

@Repository
public class AppointmentRepositoryImpl implements AppointmentRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppointmentRepositoryImpl.class);

	@Resource
	Environment environment;

	@Autowired
	@Qualifier("mappingNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private String SQL = null;
	
	@Autowired
	DoctorService doctorService;

	@Override
	public int checkAppointmentExists(Appointment appointment) {

		SQL = environment.getRequiredProperty("FETCH_APPOINTMENT");

		List<String> query = namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource()
				.addValue("mobileNo", appointment.getMobileNo())
				.addValue("appointmentDate", appointment.getAppointmentDate())
				.addValue("doctorId", appointment.getDoctorId()),
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {

						return rs.getString("appointment_id");
					}
				});

		if (query.size() > 0) {
			return 1;
		}
		return 0;
	
	}

	@Override
	public int addAppointment(Appointment appointment) {
		
		SQL = environment.getRequiredProperty("INSERT_APPOINTMENT");
		
		 int update = namedParameterJdbcTemplate.update(SQL,
				new MapSqlParameterSource()
						.addValue("patientFirstName", appointment.getPatientFirstName())
						.addValue("patientLastName", appointment.getPatientLastName())
						.addValue("mobileNo", appointment.getMobileNo())
						.addValue("departmentId", appointment.getDepartmentId())
						.addValue("doctorId", appointment.getDoctorId())
						.addValue("appointmentDay", appointment.getAppointmentDay())
						.addValue("appointmentSlot", appointment.getAppointmentSlot())
						.addValue("allotedSlot", appointment.getAllotedSlot())
						.addValue("appointmentDate", appointment.getAppointmentDate())
						.addValue("visitingType", appointment.getVisitingType())
						.addValue("gender", appointment.getGender())
						.addValue("patientAge", appointment.getAge())
						.addValue("reference", appointment.getReference())
						.addValue("address", appointment.getAddress())
						.addValue("appointmentStatus", 1)
						.addValue("insertId", appointment.getInsertId())
						.addValue("updateId", appointment.getUpdateId())
						);
		 
		 if(update > 0) {
			 try {
				 //generateAppoinmentMsg(appointment);
					// Below example is for sending Plain text
					Sender s = new Sender("9987969980", "Dreamz@11", generateAppoinmentMsg(appointment), appointment.getMobileNo(), "TSTMSG");
					s.submitMessage();
				} catch (Exception ex) {
					LOGGER.info("Error sending message to {}", appointment.getMobileNo());
				}
		 }
		return update;
	}

	@Override
	public List<Appointment> fetchAllAppointments() {
		SQL = environment.getRequiredProperty("FETCH_ALL_APPOINTMENT");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<Appointment>() {

					@Override
					public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Appointment appointment = new Appointment();
						appointment.setAppointmentId(rs.getInt("appointment_id"));
						appointment.setPatientFirstName(rs.getString("patient_first_name"));
						appointment.setPatientLastName(rs.getString("patient_last_name"));
						appointment.setMobileNo(rs.getString("mobile_no"));
						appointment.setDepartmentId(rs.getString("department_id"));
						appointment.setDepartmentName(rs.getString("department_name"));
						appointment.setDoctorId(rs.getString("doctor_id"));
						appointment.setDoctorName(rs.getString("doctor_name"));
						appointment.setAppointmentDay(rs.getString("appointment_day"));
						appointment.setAppointmentSlot(rs.getString("appointment_slot"));
						appointment.setAllotedSlot(rs.getString("alloted_slot"));
						appointment.setAppointmentDate(rs.getDate("appointment_date"));
						appointment.setVisitingType(rs.getString("visiting_type"));
						appointment.setStatus(rs.getInt("appointment_status"));
						appointment.setInsertId(rs.getString("insert_id"));
						appointment.setUpdateId(rs.getString("update_id"));
						appointment.setInsertDate(rs.getTimestamp("insert_date"));
						appointment.setUpdateDate(rs.getTimestamp("update_date"));
						
						return appointment;
					}
				});
	}

	@Override
	public Statistics fetchStatistics() {
		SQL = environment.getRequiredProperty("FETCH_STATISTICS");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<Statistics>() {

					@Override
					public Statistics mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Statistics statistics = new Statistics();
						statistics.setTotalCalls(rs.getInt("totatlAppointments"));
						statistics.setTodayCalls(rs.getInt("todayslAppointments"));
						statistics.setTotalDepartments(rs.getInt("totalDepartments"));
						statistics.setTotalDocotrs(rs.getInt("totalDoctors"));
						return statistics;
					}
				}).get(0);
	}
	
	private String generateAppoinmentMsg(Appointment appointment) {
		
		String doctorName =  doctorService.fetchDoctorNameById(appointment.getDoctorId());
		String date = new SimpleDateFormat("dd-MM-yyyy").format(appointment.getAppointmentDate());
		String msg = "Dear Sir/Madam,\r\n" + 
				"Your "+appointment.getDepartmentName()+" appointment with "+doctorName+" is scheduled on "+date+" at "+appointment.getAllotedSlot()+" AM/PM at H. J. Doshi G. H. S. Hospital. Kindly be on time.\r\n" + 
				"*Terms & Condition Applied.\r\n" + 
				"http://bit.ly/2XIbuwo";
		
		//LOGGER.info(msg);
		return msg;
	}

	@Override
	public int updateAppointmentStatus(String appointmentId) {
		SQL = environment.getRequiredProperty("UPDATE_APPOINTMENT_STATUS");
		
		 return namedParameterJdbcTemplate.update(SQL,
				new MapSqlParameterSource()
						.addValue("appointmentId", appointmentId));
	}

}
