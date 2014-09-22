package com.youtube.rest.status;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import com.youtube.dao.*;

@Path("/v1/status")
public class V1_status {
	
	private static final String API_VERSION = "00.01.00";
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle() {
		return "<p>Java Web Serviceee</p>";
	}
	
	@Path("/version")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnVersion() {
		return "<p>Version: </p>" + API_VERSION;
	}
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception{
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try{
			conn = DataSourceSelection.getMySQLDataSource().getConnection();
			query = conn.prepareStatement("select * from tb_tv_channel");
			ResultSet rs = query.executeQuery();
			
			while(rs.next()){
				returnString = returnString + rs.getString("code") + rs.getString("name");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn != null )
				conn.close();
			query.close();
		}
		return returnString;
	}
}
