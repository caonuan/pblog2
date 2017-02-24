package pblog.service.impl;

import org.springframework.stereotype.Service;

import pblog.entity.Statistics;
import pblog.service.StatisticsService;
@Service("statisticsService")
public class StatisticsServiceImpl implements StatisticsService {

	@Override
	public Statistics getStatistics() {
		return null;
	}

	@Override
	public String setStatistics(int todayAccess, int sumAccess) {
		return null;
	}

}
