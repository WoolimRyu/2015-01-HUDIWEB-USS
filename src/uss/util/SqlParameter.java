package uss.util;

import java.util.ArrayList;

public class SqlParameter {
	private String sql;
	private ArrayList<Object> parameter;
	
	public SqlParameter(String sql, ArrayList<Object> parameter) {
		this.sql = sql;
		this.parameter = parameter;
	}
	public String getSql() {
		return sql;
	}
	public ArrayList<Object> getParameter() {
		return parameter;
	}
}
