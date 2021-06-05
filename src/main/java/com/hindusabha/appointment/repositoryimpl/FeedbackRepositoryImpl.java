package com.hindusabha.appointment.repositoryimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.hindusabha.appointment.dto.Feedback;
import com.hindusabha.appointment.dto.FeedbackStatistics;
import com.hindusabha.appointment.dto.VaccinationFeedback;
import com.hindusabha.appointment.dto.VaccinationStatistics;
import com.hindusabha.appointment.repository.FeedbackRepository;
import com.hindusabha.appointment.sms.Sender;

@Repository
public class FeedbackRepositoryImpl implements FeedbackRepository{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackRepositoryImpl.class);

	@Resource
	Environment environment;

	@Autowired
	@Qualifier("mappingNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private String SQL = null;

	@Override
	public int saveFeedback(Feedback feedback) {
		 SQL = environment.getRequiredProperty("INSERT_FEEDBACK");
		
		  int update = namedParameterJdbcTemplate.update(SQL,
				new MapSqlParameterSource()
						.addValue("patientName", feedback.getPatientName())
						.addValue("address", feedback.getAddress())
						.addValue("bedNo", feedback.getBedNo())
						.addValue("mobileNo", feedback.getMobileNo())
						.addValue("ipNumber", feedback.getIpNumber())
						.addValue("relativeName", feedback.getRelativeName())
						.addValue("relation", feedback.getRelation())
						.addValue("rating1", feedback.getRating1())
						.addValue("rating2", feedback.getRating2())
						.addValue("rating3", feedback.getRating3())
						.addValue("rating4", feedback.getRating4())
						.addValue("rating5", feedback.getRating5())
						.addValue("suggestions", feedback.getSuggestions())
						.addValue("status", "1")
						.addValue("insertId", "dev")
						.addValue("updateId", "dev")
						);
		 
		 if(update > 0) {
			 try {
				 String text = String.format("%.0f", feedback.getMobileNo());
				 LOGGER.info("Mobile No: = "+String.valueOf(text));
				 //generateAppoinmentMsg(appointment);
					// Below example is for sending Plain text
				 String sms = "Thank you for your feedback, For Emergency please contact 022-68341414";
					Sender s = new Sender("9987969980", "Dreamz@11", sms,String.valueOf(text), "TSTMSG");
					s.submitMessage();
				} catch (Exception ex) {
					LOGGER.info("Error sending message to {}", feedback.getMobileNo());
				}
		 }
		 
		 return update;
	}
	
	@Override
	public int saveVaccinationFeedback(VaccinationFeedback feedback) {
		 SQL = environment.getRequiredProperty("INSERT_VACCINATION_FEEDBACK");
		LOGGER.info(SQL);
		 return namedParameterJdbcTemplate.update(SQL,
				new MapSqlParameterSource()
						.addValue("doseType", feedback.getDoseType())
						.addValue("patientName", feedback.getPatientName())
						.addValue("contactNumber", feedback.getContactNumber())
						.addValue("locality", feedback.getLocality())
						.addValue("feedback1", feedback.getFeedback1())
						.addValue("feedback2", feedback.getFeedback2())
						.addValue("feedback3", feedback.getFeedback3())
						.addValue("feedback4", feedback.getFeedback4())
						.addValue("feedback5", feedback.getFeedback5())
						.addValue("status", "1")
						.addValue("insertId", "dev")
						.addValue("updateId", "dev")
						);
	}

	@Override
	public List<VaccinationFeedback> fetchVaccinationDetails() {
		SQL = environment.getRequiredProperty("FETCH_VACCINATION_DETAILS");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<VaccinationFeedback>() {

					@Override
					public VaccinationFeedback mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						VaccinationFeedback feedback = new VaccinationFeedback();
						feedback.setFeedId(rs.getInt("feed_id"));
						feedback.setPatientName(rs.getString("patient_name"));
						feedback.setContactNumber(rs.getDouble("contact_number"));
						feedback.setLocality(rs.getString("locality"));
						feedback.setFeedback1(rs.getString("feedback_1"));
						feedback.setFeedback2(rs.getString("feedback_2"));
						feedback.setFeedback3(rs.getString("feedback_3"));
						feedback.setFeedback4(rs.getString("feedback_4"));
						feedback.setFeedback5(rs.getString("feedback_5"));
						feedback.setStatus(rs.getString("status"));
						feedback.setInsertId(rs.getString("insert_id"));
						feedback.setUpdateId(rs.getString("update_id"));
						feedback.setInsertDate(rs.getTimestamp("insert_date"));
						feedback.setUpdateDate(rs.getTimestamp("update_date"));
						
						return feedback;
					}
				});
	}

	@Override
	public VaccinationStatistics fetchVaccinationStatistics() {
		SQL = environment.getRequiredProperty("FETCH_VACCINATION_STATISTICS");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<VaccinationStatistics>() {

					@Override
					public VaccinationStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						VaccinationStatistics statistics = new VaccinationStatistics();
						statistics.setTotalVaccinated(rs.getInt("TotalVaccinations"));
						statistics.setTodayVaccinated(rs.getInt("TodaysVaccination"));
						return statistics;
					}
				}).get(0);
	}
	
	@Override
	public List<Feedback> fetchIpdDetails() {
		SQL = environment.getRequiredProperty("FETCH_IPD_DETAILS");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<Feedback>() {

					@Override
					public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Feedback feedback = new Feedback();
						feedback.setFeedbackId(rs.getInt("feedback_id"));
						feedback.setPatientName(rs.getString("patient_name"));
						feedback.setAddress(rs.getString("address"));
						feedback.setBedNo(rs.getString("bed_no"));
						feedback.setMobileNo(rs.getDouble("mobile_no"));
						feedback.setIpNumber(rs.getString("ip_number"));
						feedback.setRelativeName(rs.getString("relative_name"));
						feedback.setRelation(rs.getString("relation"));
						feedback.setRating1(rs.getDouble("rating_1"));
						feedback.setRating2(rs.getDouble("rating_2"));
						feedback.setRating3(rs.getDouble("rating_3"));
						feedback.setRating4(rs.getDouble("rating_4"));
						feedback.setRating5(rs.getDouble("rating_5"));
						feedback.setSuggestions(rs.getString("suggestions"));
						feedback.setStatus(rs.getString("status"));
						feedback.setInsertId(rs.getString("insert_id"));
						feedback.setUpdateId(rs.getString("update_id"));
						feedback.setInsertDate(rs.getTimestamp("insert_date"));
						feedback.setUpdateDate(rs.getTimestamp("update_date"));
						
						return feedback;
					}
				});
	}
	
	@Override
	public FeedbackStatistics fetchIpdStatistics() {
		SQL = environment.getRequiredProperty("FETCH_IPD_STATISTICS");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<FeedbackStatistics>() {

					@Override
					public FeedbackStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						FeedbackStatistics statistics = new FeedbackStatistics();
						statistics.setTotalIpd(rs.getInt("total_ipd"));
						statistics.setTodayIpd(rs.getInt("today_ipd"));
						statistics.setAvgRating(rs.getDouble("avg_rating"));
						return statistics;
					}
				}).get(0);
	}

}
