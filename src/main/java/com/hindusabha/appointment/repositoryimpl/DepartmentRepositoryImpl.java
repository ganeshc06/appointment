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
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.hindusabha.appointment.dto.Appointment;
import com.hindusabha.appointment.dto.Department;
import com.hindusabha.appointment.dto.DoctorDepartmentMapping;
import com.hindusabha.appointment.repository.DepartmentRepository;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorRepositoryImpl.class);

	@Resource
	Environment environment;

	@Autowired
	@Qualifier("mappingNamedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private String SQL = null;

	@Override
	public int addDepartment(String departmentName, String userName) {
		SQL = environment.getRequiredProperty("INSERT_DEPARTMENT");

		return namedParameterJdbcTemplate.update(SQL,
				new MapSqlParameterSource()
				.addValue("departmentName", departmentName)
				.addValue("status", 1)
				.addValue("insertId", userName)
				.addValue("updateId", userName));
	}

	@Override
	public Department fetchDepartment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department fetchDepartmentById(String departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkDepartmentExists(String departmentName) {
		SQL = environment.getRequiredProperty("FETCH_DEPARTMENT");

		List<String> query = namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource().addValue("departmentName", departmentName),
				new RowMapper<String>() {

					@Override
					public String mapRow(ResultSet rs, int rowNum) throws SQLException {

						return rs.getString("department_name");
					}
				});

		if (query.size() > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public List<Department> fetchAllDepartments() {
		SQL = environment.getRequiredProperty("FETCH_ALL_DEPARTMENT");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource(),
				new RowMapper<Department>() {

					@Override
					public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						Department department = new Department();
						department.setDepartmantId(rs.getInt("department_id"));
						department.setDepartmentName(rs.getString("department_name"));
						department.setStatus(rs.getInt("status"));
						department.setInsertId(rs.getString("insert_id"));
						department.setUpdateId(rs.getString("update_id"));
						department.setInsertDate(rs.getTimestamp("insert_date"));
						department.setUpdateDate(rs.getTimestamp("update_date"));
						return department;
					}
				});
	}

	@Override
	public int[] insertMappingBatch(List<DoctorDepartmentMapping> mappingList) {
		SQL = environment.getProperty("INSERT_MAPPING");
		SqlParameterSource[] listOfMappings = SqlParameterSourceUtils.createBatch(mappingList.toArray());
		return namedParameterJdbcTemplate.batchUpdate(SQL,listOfMappings);
	}

	@Override
	public List<DoctorDepartmentMapping> fetchMappingByDepartment(String departmentId) {

		SQL = environment.getRequiredProperty("FETCH_MAPPING");

		return namedParameterJdbcTemplate.query(SQL,
				new MapSqlParameterSource().addValue("departmentId", departmentId),
				new RowMapper<DoctorDepartmentMapping>() {

					@Override
					public DoctorDepartmentMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
						
						DoctorDepartmentMapping mapping = new DoctorDepartmentMapping();
						mapping.setMappingId(rs.getInt("mapping_id"));
						mapping.setDepartmentId(rs.getInt("department_id"));
						mapping.setDoctorId(rs.getInt("doctor_id"));
						mapping.setStatus(rs.getInt("status"));
						mapping.setInsertId(rs.getString("insert_id"));
						mapping.setUpdateId(rs.getString("update_id"));
						mapping.setInsertDate(rs.getTimestamp("insert_date"));
						mapping.setUpdateDate(rs.getTimestamp("update_date"));
						
						return mapping;
					}
				});
	
	}

	@Override
	public int deleteMappingByDepartmentId(String departmentId) {
		
		SQL=environment.getRequiredProperty("DELETE_MAPPING");
		
		return namedParameterJdbcTemplate.update(SQL, new MapSqlParameterSource()
		.addValue("departmentId",departmentId));
	}

}
