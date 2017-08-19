package pblog.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Scope("prototype")
@Entity
@Table
public class Statistics {

	private int statisticsId;
	private int todayAccess;
	private int sumAccess;

	public Statistics() {
	}

	public Statistics(int statisticsId, int todayAccess, int sumAccess) {
		super();
		this.statisticsId = statisticsId;
		this.todayAccess = todayAccess;
		this.sumAccess = sumAccess;
	}

	@Id
	@GeneratedValue
	@Column(name = "statisticsId")
	public int getStatisticsId() {
		return statisticsId;
	}

	public void setStatisticsId(int statisticsId) {
		this.statisticsId = statisticsId;
	}

	@Column(name = "todayAccess")
	public int getTodayAccess() {
		return todayAccess;
	}

	public void setTodayAccess(int todayAccess) {
		this.todayAccess = todayAccess;
	}

	@Column(name = "sumAccess")
	public int getSumAccess() {
		return sumAccess;
	}

	public void setSumAccess(int sumAccess) {
		this.sumAccess = sumAccess;
	}

}
