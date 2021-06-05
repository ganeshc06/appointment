package com.hindusabha.appointment.dto;

public class FeedbackStatistics {

	private int totalIpd;
	private int todayIpd;
	private Double avgRating;

	public int getTotalIpd() {
		return totalIpd;
	}

	public void setTotalIpd(int totalIpd) {
		this.totalIpd = totalIpd;
	}

	public int getTodayIpd() {
		return todayIpd;
	}

	public void setTodayIpd(int todayIpd) {
		this.todayIpd = todayIpd;
	}

	public Double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	@Override
	public String toString() {
		return "FeedbackStatistics [totalIpd=" + totalIpd + ", todayIpd=" + todayIpd + ", avgRating=" + avgRating + "]";
	}

}
