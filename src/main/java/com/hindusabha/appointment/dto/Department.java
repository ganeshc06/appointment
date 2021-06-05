package com.hindusabha.appointment.dto;

import java.sql.Timestamp;

public class Department {

	private int departmantId;
	private String departmentName;
	private int status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getDepartmantId() {
		return departmantId;
	}

	public void setDepartmantId(int departmantId) {
		this.departmantId = departmantId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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
		return "Department [departmantId=" + departmantId + ", departmentName=" + departmentName + ", status=" + status
				+ ", insertId=" + insertId + ", updateId=" + updateId + ", insertDate=" + insertDate + ", updateDate="
				+ updateDate + "]";
	}

}
