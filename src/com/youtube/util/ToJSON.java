package com.youtube.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Types;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

public class ToJSON {
	public JSONArray toJSONArray(ResultSet rs) throws Exception {
		JSONArray json = new JSONArray();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				int numColumns = rsmd.getColumnCount();
				JSONObject obj = new JSONObject();
				for(int i=1; i<numColumns+1; i++){
					String column_name = rsmd.getColumnName(i);
					if(rsmd.getColumnType(i)==Types.ARRAY){
						obj.put(column_name, rs.getArray(column_name));
						System.out.println("ToJson: ARRAY");
					}else if(rsmd.getColumnType(i)==Types.BIGINT){
						obj.put(column_name, rs.getInt(column_name));
						System.out.println("ToJson: BIGINT");
					}else if(rsmd.getColumnType(i)==Types.BOOLEAN){
						obj.put(column_name, rs.getBoolean(column_name));
						System.out.println("ToJson: BOOLEAN");
					}else if(rsmd.getColumnType(i)==Types.BLOB){
						obj.put(column_name, rs.getBlob(column_name));
						System.out.println("ToJson: BLOB");
					}else if(rsmd.getColumnType(i)==Types.DOUBLE){
						obj.put(column_name, rs.getDouble(column_name));
						System.out.println("ToJson: DOUBLE");
					}else if(rsmd.getColumnType(i)==Types.FLOAT){
						obj.put(column_name, rs.getFloat(column_name));
						System.out.println("ToJson: FLOAT");
					}else if(rsmd.getColumnType(i)==Types.INTEGER){
						obj.put(column_name, rs.getInt(column_name));
						System.out.println("ToJson: INTEGER");
					}else if(rsmd.getColumnType(i)==Types.NVARCHAR){
						obj.put(column_name, rs.getNString(column_name));
						System.out.println("ToJson: NVARCHAR");
					}else if(rsmd.getColumnType(i)==Types.VARCHAR){
						obj.put(column_name, rs.getString(column_name));
						System.out.println("ToJson: VARCHAR");
					}else if(rsmd.getColumnType(i)==Types.TINYINT){
						obj.put(column_name, rs.getInt(column_name));
						System.out.println("ToJson: TINYINT");
					}else if(rsmd.getColumnType(i)==Types.SMALLINT){
						obj.put(column_name, rs.getInt(column_name));
						System.out.println("ToJson: SMALLINT");
					}else if(rsmd.getColumnType(i)==Types.DATE){
						obj.put(column_name, rs.getDate(column_name));
						System.out.println("ToJson: DATE");
					}else if(rsmd.getColumnType(i)==Types.TIMESTAMP){
						obj.put(column_name, rs.getTimestamp(column_name));
						System.out.println("ToJson: TIMESTAMP");
					}else if(rsmd.getColumnType(i)==Types.NUMERIC){
						obj.put(column_name, rs.getBigDecimal(column_name));
						System.out.println("ToJson: NUMERIC");
					}else {
						obj.put(column_name, rs.getObject(column_name));
						System.out.println("ToJson: FLOAT");
					}
				}
				json.put(obj);
			}
		} catch (Exception e) {
			System.out.println("something wrong");
		}
		return json;
	}
}
