package uss.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class SqlSupport {

	public SqlParameter getSelectSql(Object object) {
		String sql = "SELECT * FROM %s WHERE %s";
		Map<Field, Object> map = getParameter(object);
		ArrayList<Object> valueList = new ArrayList<Object>();

		String parameter = "";
		for (Field key : map.keySet()) {
			parameter += key.getName() + " = ?, ";
			valueList.add(map.get(key));
		}
		parameter = parameter.substring(0, parameter.length() - 2);
		sql = String.format(sql, object.getClass().getSimpleName(), parameter);
		return new SqlParameter(sql, valueList);
	}

	public SqlParameter getUpdateSql(Object object) {
		String sql = "UPDATE %s SET %s WHERE %s";
		Map<Field, Object> map = getParameter(object);
		ArrayList<Object> valueList = new ArrayList<Object>();
		ArrayList<Object> setValueList = new ArrayList<Object>();

		String parameter = "";
		String setParameter = "";
		for (Field key : map.keySet()) {
			if(key.getName().endsWith("Id")) {
				parameter += key.getName() + " = ?, ";
				valueList.add(map.get(key));
			}
			else {
				setParameter += key.getName() + " = ?, ";
				setValueList.add(map.get(key));
			}
		}
		parameter = parameter.substring(0, parameter.length() - 2);
		setParameter = setParameter.substring(0, setParameter.length() - 2);
		sql = String.format(sql, object.getClass().getSimpleName(), setParameter, parameter);
		
		for (Object value : valueList) {
			setValueList.add(value);
		}

		return new SqlParameter(sql, setValueList);
	}

	public Map<Field, Object> getParameter(Object object) {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();
		Map<Field, Object> parameterMap = new LinkedHashMap<Field, Object>();

		for (Field field : fields) {
			field.setAccessible(true);
			try {
				Object value = field.get(object);
				if (value == null)
					continue;
				parameterMap.put(field, value);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return parameterMap;
	}

}
