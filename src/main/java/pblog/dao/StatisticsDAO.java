package pblog.dao;

import pblog.entity.Statistics;

public interface StatisticsDAO {
	/**
	 * 获取状态
	 * @return
	 */
	public Statistics getSatistics();
	
	/**
	 * 存储状态。编写为每天0点自动运行一次。
	 * @param statistics
	 * @return
	 */
	public boolean setStatistics(Statistics statistics);
}
