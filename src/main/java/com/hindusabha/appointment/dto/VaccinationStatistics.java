package com.hindusabha.appointment.dto;

public class VaccinationStatistics {

	private int totalVaccinated;
	private int todayVaccinated;

	public int getTotalVaccinated() {
		return totalVaccinated;
	}

	public void setTotalVaccinated(int totalVaccinated) {
		this.totalVaccinated = totalVaccinated;
	}

	public int getTodayVaccinated() {
		return todayVaccinated;
	}

	public void setTodayVaccinated(int todayVaccinated) {
		this.todayVaccinated = todayVaccinated;
	}

	@Override
	public String toString() {
		return "VaccinationStatistics [totalVaccinated=" + totalVaccinated + ", todayVaccinated=" + todayVaccinated
				+ "]";
	}

}
