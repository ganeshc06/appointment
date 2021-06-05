package com.hindusabha.appointment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hindusabha.appointment.dto.AppUser;

public class AppUserMapper implements RowMapper<AppUser> {

	public static final String BASE_SQL = "Select u.user_id, u.username, u.password, u.encrypt_password From login u ";

	@Override
	public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {

		String userId = rs.getString("user_id");
		String userName = rs.getString("username");
		String password = rs.getString("password");
		String encryptedPassword = rs.getString("encrypt_password");

		return new AppUser(userId, userName, password,encryptedPassword);
	}

}
