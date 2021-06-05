package com.hindusabha.appointment.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppRoleDAO extends JdbcDaoSupport {

	@Autowired
	public AppRoleDAO(@Autowired @Qualifier("mappingDataSource") DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<String> getRoleNames(String userId) {
		String sql = "Select u.user_role " //
				+ " from login u" //
				+ " where u.user_id =?";

		Object[] params = new Object[] { userId };

		List<String> roles = this.getJdbcTemplate().queryForList(sql, params, String.class);

		return roles;
	}

}
