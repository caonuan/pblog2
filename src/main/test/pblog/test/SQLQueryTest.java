package pblog.test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.impl.SQLQuery;

public class SQLQueryTest {
	private ApplicationContext context = null;
	private SQLQuery sqlQuery = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		sqlQuery=context.getBean(SQLQuery.class);
	}
	
	@Test
	public void sqlquerytest(){
		ResultSet resultSet= sqlQuery.makeSQLQuery("select * from visitor");
		try {
			ResultSetMetaData rsd=resultSet.getMetaData();
			int num=rsd.getColumnCount();
			for(int i=1;i<=num;i++){
				System.out.print(rsd.getColumnName(i)+"\t");
			}
			while(resultSet.next()){
				System.out.println();
				for(int i=1;i<=num;i++){
					System.out.print(resultSet.getString(i)+"\t");
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
