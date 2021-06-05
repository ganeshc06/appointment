package com.hindusabha.appointment.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class Appointment {

	private int appointmentId;
	private String patientFirstName;
	private String patientLastName;
	private String mobileNo;
	private String departmentId;
	private String departmentName;
	private String doctorId;
	private String doctorName;
	private String appointmentDay;
	private String appointmentSlot;
	private String allotedSlot;
	private String gender;
	private int age;
	private Date appointmentDate;
	private String visitingType;
	private String reference;
	private String address;
	private int status;
	private String insertId;
	private String updateId;
	private Timestamp insertDate;
	private Timestamp updateDate;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getPatientFirstName() {
		return patientFirstName;
	}

	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}

	public String getPatientLastName() {
		return patientLastName;
	}

	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAppointmentDay() {
		return appointmentDay;
	}

	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}

	public String getAppointmentSlot() {
		return appointmentSlot;
	}

	public void setAppointmentSlot(String appointmentSlot) {
		this.appointmentSlot = appointmentSlot;
	}

	public String getAllotedSlot() {
		return allotedSlot;
	}

	public void setAllotedSlot(String allotedSlot) {
		this.allotedSlot = allotedSlot;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getVisitingType() {
		return visitingType;
	}

	public void setVisitingType(String visitingType) {
		this.visitingType = visitingType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "Appointment [appointmentId=" + appointmentId + ", patientFirstName=" + patientFirstName
				+ ", patientLastName=" + patientLastName + ", mobileNo=" + mobileNo + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", appointmentDay=" + appointmentDay + ", appointmentSlot=" + appointmentSlot + ", allotedSlot="
				+ allotedSlot + ", gender=" + gender + ", age=" + age + ", appointmentDate=" + appointmentDate
				+ ", visitingType=" + visitingType + ", reference=" + reference + ", address=" + address + ", status="
				+ status + ", insertId=" + insertId + ", updateId=" + updateId + ", insertDate=" + insertDate
				+ ", updateDate=" + updateDate + "]";
	}

}
