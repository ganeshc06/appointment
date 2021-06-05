package com.hindusabha.appointment.dto;

import java.sql.Timestamp;

public class Feedback {

	private int feedbackId;
	private String patientName;
	private String address;
	private String bedNo;
	private Double mobileNo;
	private String ipNumber;
	private String relativeName;
	private String relation;
	private Double rating1;
	private Double rating2;
	private Double rating3;
	private Double rating4;
	private Double rating5;
	private String suggestions;
	private String status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public Double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Double mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getIpNumber() {
		return ipNumber;
	}

	public void setIpNumber(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Double getRating1() {
		return rating1;
	}

	public void setRating1(Double rating1) {
		this.rating1 = rating1;
	}

	public Double getRating2() {
		return rating2;
	}

	public void setRating2(Double rating2) {
		this.rating2 = rating2;
	}

	public Double getRating3() {
		return rating3;
	}

	public void setRating3(Double rating3) {
		this.rating3 = rating3;
	}

	public Double getRating4() {
		return rating4;
	}

	public void setRating4(Double rating4) {
		this.rating4 = rating4;
	}

	public Double getRating5() {
		return rating5;
	}

	public void setRating5(Double rating5) {
		this.rating5 = rating5;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
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
		return "Feedback [feedbackId=" + feedbackId + ", patientName=" + patientName + ", address=" + address
				+ ", bedNo=" + bedNo + ", mobileNo=" + mobileNo + ", ipNumber=" + ipNumber + ", relativeName="
				+ relativeName + ", relation=" + relation + ", rating1=" + rating1 + ", rating2=" + rating2
				+ ", rating3=" + rating3 + ", rating4=" + rating4 + ", rating5=" + rating5 + ", suggestions="
				+ suggestions + ", status=" + status + ", insertId=" + insertId + ", updateId=" + updateId
				+ ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}

}
