package uss.util;

public class SqlParameter {
	private String sql;
	private Object[] parameter;
	
	public SqlParameter(String sql, Object[] objects) {
		this.sql = sql;
		this.parameter = objects;
	}
	public String getSql() {
		return sql;
	}
	public Object[] getParameter() {
		return parameter;
	}
}
