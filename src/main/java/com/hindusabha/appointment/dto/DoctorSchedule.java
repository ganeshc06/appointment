package com.hindusabha.appointment.dto;

import java.sql.Timestamp;
import java.util.LinkedList;

public class DoctorSchedule {

	private int doctorId;
	private String doctorName;
	private String mobileNo;
	private String patientLimit;
	private LinkedList<String> days = new LinkedList<>();
	private LinkedList<String> startTime = new LinkedList<>();
	private LinkedList<String> endTime = new LinkedList<>();
	private int status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getPatientLimit() {
		return patientLimit;
	}

	public void setPatientLimit(String patientLimit) {
		this.patientLimit = patientLimit;
	}

	public LinkedList<String> getDays() {
		return days;
	}

	public void setDays(LinkedList<String> days) {
		this.days = days;
	}

	public LinkedList<String> getStartTime() {
		return startTime;
	}

	public void setStartTime(LinkedList<String> startTime) {
		this.startTime = startTime;
	}

	public LinkedList<String> getEndTime() {
		return endTime;
	}

	public void setEndTime(LinkedList<String> endTime) {
		this.endTime = endTime;
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
		return "DoctorSchedule [doctorId=" + doctorId + ", doctorName=" + doctorName + ", mobileNo=" + mobileNo
				+ ", patientLimit=" + patientLimit + ", days=" + days + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", insertId=" + insertId + ", updateId=" + updateId + ", insertDate="
				+ insertDate + ", updateDate=" + updateDate + "]";
	}

}
