package com.hindusabha.appointment.dto;

import java.sql.Timestamp;

public class DoctorDepartmentMapping {

	private int mappingId;
	private int departmentId;
	private int doctorId;
	private int status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getMappingId() {
		return mappingId;
	}

	public void setMappingId(int mappingId) {
		this.mappingId = mappingId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getInsertId() {
		return insertId;
	}

	public void setInsertId(String insertId) {
		this.insertId = insertId;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Timestamp getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "DoctorDepartmentMapping [mappingId=" + mappingId + ", departmentId=" + departmentId + ", doctorId="
				+ doctorId + ", status=" + status + ", insertId=" + insertId + ", updateId=" + updateId
				+ ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}

}
