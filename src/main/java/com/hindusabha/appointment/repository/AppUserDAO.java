package com.hindusabha.appointment.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hindusabha.appointment.dto.AppUser;
import com.hindusabha.appointment.mapper.AppUserMapper;

@Repository
@Transactional
public class AppUserDAO extends JdbcDaoSupport {

	@Autowired
	public AppUserDAO(@Autowired @Qualifier("mappingDataSource") DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public AppUser findUserAccount(String userName) {
		String sql = AppUserMapper.BASE_SQL + " where u.username = ? ";

		Object[] params = new Object[] { userName };
		AppUserMapper mapper = new AppUserMapper();
		try {
			AppUser userInfo = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}
}
