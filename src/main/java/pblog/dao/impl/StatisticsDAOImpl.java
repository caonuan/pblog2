package pblog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import pblog.dao.StatisticsDAO;
import pblog.entity.Statistics;

@Component("statisticsDAO")
public class StatisticsDAOImpl implements StatisticsDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Statistics getSatistics() {
		Statistics statistics=(Statistics) hibernateTemplate.find("from pblog.entity.Statistics").get(0);
		return statistics;
	}

	@Override
	public boolean setStatistics(Statistics statistics) {
		hibernateTemplate.update(statistics);
		return true;
	}

}
