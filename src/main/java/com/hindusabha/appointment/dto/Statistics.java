package com.hindusabha.appointment.dto;

public class Statistics {

	private int totalCalls;
	private int todayCalls;
	private int totalDepartments;
	private int totalDocotrs;

	public int getTotalCalls() {
		return totalCalls;
	}

	public void setTotalCalls(int totalCalls) {
		this.totalCalls = totalCalls;
	}

	public int getTodayCalls() {
		return todayCalls;
	}

	public void setTodayCalls(int todayCalls) {
		this.todayCalls = todayCalls;
	}

	public int getTotalDepartments() {
		return totalDepartments;
	}

	public void setTotalDepartments(int totalDepartments) {
		this.totalDepartments = totalDepartments;
	}

	public int getTotalDocotrs() {
		return totalDocotrs;
	}

	public void setTotalDocotrs(int totalDocotrs) {
		this.totalDocotrs = totalDocotrs;
	}

	@Override
	public String toString() {
		return "Statistics [totalCalls=" + totalCalls + ", todayCalls=" + todayCalls + ", totalDepartments="
				+ totalDepartments + ", totalDocotrs=" + totalDocotrs + "]";
	}

}
