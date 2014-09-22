package com.youtube.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.*;
import javax.sql.*;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceSelection {

	private static DataSource Oracle308tube = null;
	private static Context context = null;
	
	public static DataSource oracle308tubeConn() throws Exception{
		try{
			
		}catch(Exception e){
			
		}
		return Oracle308tube;
	}
	
	    public static DataSource getMySQLDataSource() {
	        Properties props = new Properties();
	        InputStream  fis = null;
	        MysqlDataSource mysqlDS = null;
	        try {
	        	fis = DataSourceSelection.class.getClassLoader().getResourceAsStream("db.properties");
//	            fis = new FileInputStream("db.properties");
	            props.load(fis);
	            mysqlDS = new MysqlDataSource();
	            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
	            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
	            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return mysqlDS;
	    }
}
