package pblog.service;

import pblog.entity.Statistics;

public interface StatisticsService {
	public Statistics getStatistics();

	public String setStatistics(int todayAccess, int sumAccess);
}
