package pblog.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.StatisticsDAO;
import pblog.entity.Statistics;

public class StatisticsDAOImplTest {
	private ApplicationContext context = null;
	private StatisticsDAO sdao = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		sdao = (StatisticsDAO) context.getBean("statisticsDAO");

	}

	@Test
	public void getSatisticsTest(){
		Statistics statistics= sdao.getSatistics();
		System.out.println(statistics.getSumAccess()+","+statistics.getTodayAccess());
	}
}
