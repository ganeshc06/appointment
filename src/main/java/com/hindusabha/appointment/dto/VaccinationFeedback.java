package com.hindusabha.appointment.dto;

import java.sql.Timestamp;

public class VaccinationFeedback {

	private int feedId;
	private String doseType;
	private String patientName;
	private Double contactNumber;
	private String locality;
	private String feedback1;
	private String feedback2;
	private String feedback3;
	private String feedback4;
	private String feedback5;
	private String status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getDoseType() {
		return doseType;
	}

	public void setDoseType(String doseType) {
		this.doseType = doseType;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Double getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Double contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getFeedback1() {
		return feedback1;
	}

	public void setFeedback1(String feedback1) {
		this.feedback1 = feedback1;
	}

	public String getFeedback2() {
		return feedback2;
	}

	public void setFeedback2(String feedback2) {
		this.feedback2 = feedback2;
	}

	public String getFeedback3() {
		return feedback3;
	}

	public void setFeedback3(String feedback3) {
		this.feedback3 = feedback3;
	}

	public String getFeedback4() {
		return feedback4;
	}

	public void setFeedback4(String feedback4) {
		this.feedback4 = feedback4;
	}

	public String getFeedback5() {
		return feedback5;
	}

	public void setFeedback5(String feedback5) {
		this.feedback5 = feedback5;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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
		return "VaccinationFeedback [feedId=" + feedId + ", doseType=" + doseType + ", patientName=" + patientName
				+ ", contactNumber=" + contactNumber + ", locality=" + locality + ", feedback1=" + feedback1
				+ ", feedback2=" + feedback2 + ", feedback3=" + feedback3 + ", feedback4=" + feedback4 + ", feedback5="
				+ feedback5 + ", status=" + status + ", insertId=" + insertId + ", updateId=" + updateId
				+ ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}

}
