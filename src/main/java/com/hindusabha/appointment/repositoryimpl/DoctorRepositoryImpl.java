package com.hindusabha.appointment.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorSchedule;
import com.hindusabha.appointment.repository.DoctorRepository;

@Repository
public class DoctorRepositoryImpl implements DoctorRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorRepositoryImpl.class);

	@Resource
	Environment environment;

	@Autowired
	@Qualifier("mappingNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private String SQL = null;

	@Override
	public int addDoctor(DoctorSchedule doctorSchedule) {
		String SQL1 = environment.getRequiredProperty("INSERT_DOCTOR");
		String SQL2 = environment.getRequiredProperty("INSERT_DOCTOR_SCHEDULE");

		KeyHolder keyHolder = new GeneratedKeyHolder();

		int updated = namedParameterJdbcTemplate.update(SQL1,
				new MapSqlParameterSource().addValue("doctorName", doctorSchedule.getDoctorName())
						.addValue("mobileNo", doctorSchedule.getMobileNo())
						.addValue("patientLimit", doctorSchedule.getPatientLimit()).addValue("status", 1)
						.addValue("insertId", doctorSchedule.getInsertId())
						.addValue("updateId", doctorSchedule.getUpdateId()),
				keyHolder, new String[] { "doctor_id" });

		Number generatedId = keyHolder.getKey();
		int insertKey = generatedId.intValue();

		LOGGER.info("Doctor insert id = {}", insertKey);

		if (updated == 1) {
			for (int i = 0; i < doctorSchedule.getDays().size(); i++) {
				namedParameterJdbcTemplate.update(SQL2,
						new MapSqlParameterSource().addValue("doctorId", insertKey)
								.addValue("workingDay", doctorSchedule.getDays().get(i))
								.addValue("startTime", doctorSchedule.getStartTime().get(i))
								.addValue("endTime", doctorSchedule.getEndTime().get(i)).addValue("status", 1)
								.addValue("insertId", doctorSchedule.getInsertId())
								.addValue("updateId", doctorSchedule.getUpdateId()));
			}

		}

		return 1;
	}

	@Override
	public int checkDoctorExists(DoctorSchedule doctorSchedule) {
		SQL = environment.getRequiredProperty("FETCH_DOCTOR");

		List<String> query = namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource().addValue("doctorMobile", doctorSchedule.getMobileNo()),
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {

						return rs.getString("doctor_id");
					}
				});

		if (query.size() > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<DoctorSchedule> fetchDoctorsSchedule(String departmentId) {
		SQL = environment.getRequiredProperty("FETCH_DEPT_DOCTOR");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource().addValue("departmentId", departmentId),
				new RowMapper<DoctorSchedule>() {

					@Override
					public DoctorSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
						String[] workingDays = rs.getString("working_day").split(",");
						String[] startTimes = rs.getString("start_time").split(",");
						String[] endTimes = rs.getString("end_time").split(",");
						
						LinkedList<String> workDaysList = new LinkedList<>(Arrays.asList(workingDays).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						LinkedList<String> startTimeList = new LinkedList<>(Arrays.asList(startTimes).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						LinkedList<String> endTimeList = new LinkedList<>(Arrays.asList(endTimes).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						DoctorSchedule doctorSchedule = new DoctorSchedule();
						doctorSchedule.setDoctorId(rs.getInt("doctor_id"));
						doctorSchedule.setDoctorName(rs.getString("doctor_name"));
						doctorSchedule.setMobileNo(rs.getString("doctor_mobile"));
						doctorSchedule.setPatientLimit(rs.getString("patient_limit"));
						doctorSchedule.setDays(workDaysList);
						doctorSchedule.setStartTime(startTimeList);
						doctorSchedule.setEndTime(endTimeList);
						doctorSchedule.setStatus(rs.getInt("status"));
						doctorSchedule.setInsertId(rs.getString("insert_id"));
						doctorSchedule.setUpdateId(rs.getString("update_id"));
						doctorSchedule.setInsertDate(rs.getTimestamp("insert_date"));
						doctorSchedule.setUpdateDate(rs.getTimestamp("update_date"));
						
						return doctorSchedule;
					}
				});
	}

	@Override
	public List<DoctorSchedule> fetchAllDoctors() {
		SQL = environment.getRequiredProperty("FETCH_ALL_DOCTOR");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<DoctorSchedule>() {

					@Override
					public DoctorSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
						String[] workingDays = rs.getString("working_day").split(",");
						String[] startTimes = rs.getString("start_time").split(",");
						String[] endTimes = rs.getString("end_time").split(",");
						
						LinkedList<String> workDaysList = new LinkedList<>(Arrays.asList(workingDays).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						LinkedList<String> startTimeList = new LinkedList<>(Arrays.asList(startTimes).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						LinkedList<String> endTimeList = new LinkedList<>(Arrays.asList(endTimes).stream().map((obj)->obj.toString())
								.collect(Collectors.toList()));
						
						DoctorSchedule doctorSchedule = new DoctorSchedule();
						doctorSchedule.setDoctorId(rs.getInt("doctor_id"));
						doctorSchedule.setDoctorName(rs.getString("doctor_name"));
						doctorSchedule.setMobileNo(rs.getString("doctor_mobile"));
						doctorSchedule.setPatientLimit(rs.getString("patient_limit"));
						doctorSchedule.setDays(workDaysList);
						doctorSchedule.setStartTime(startTimeList);
						doctorSchedule.setEndTime(endTimeList);
						doctorSchedule.setStatus(rs.getInt("status"));
						doctorSchedule.setInsertId(rs.getString("insert_id"));
						doctorSchedule.setUpdateId(rs.getString("update_id"));
						doctorSchedule.setInsertDate(rs.getTimestamp("insert_date"));
						doctorSchedule.setUpdateDate(rs.getTimestamp("update_date"));
						
						return doctorSchedule;
					}
				});
	}

	@Override
	public String fetchDoctorNameById(String doctorId) {
		SQL = environment.getRequiredProperty("FETCH_DOCTORNAME_BY_ID");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource().addValue("doctorId", doctorId),
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {

						return rs.getString("doctor_name");
					}
				}).get(0);
	}

}
