package pblog.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
@Component("sqlQuery")
public class SQLQuery {
	@Autowired
	private BasicDataSource basicDataSource;

	public ResultSet makeSQLQuery(String sql) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet=null;
		try {
			connection= basicDataSource.getConnection();
			statement=connection.createStatement();
			resultSet= statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
}
