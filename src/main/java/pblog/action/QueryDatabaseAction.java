package pblog.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.dao.impl.SQLQuery;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Controller
@Scope("prototype")
public class QueryDatabaseAction extends BasicAction {
	@Autowired
	private SQLQuery sqlQuery;
	
	private String sql;
	private List<String> lineName;
	private ResultSet resultSet;
	
	public String query(){
		if(sql==null||sql.equals(""))
			sql="show tables";
		resultSet= sqlQuery.makeSQLQuery(sql);
		try {
			ResultSetMetaData rsd=resultSet.getMetaData();
			int num=rsd.getColumnCount();
			lineName=new ArrayList<String>();
			for(int i=1;i<=num;i++){
				lineName.add(rsd.getColumnName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public SQLQuery getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(SQLQuery sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public List<String> getLineName() {
		return lineName;
	}

	public void setLineName(List<String> lineName) {
		this.lineName = lineName;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}
	
	
}
