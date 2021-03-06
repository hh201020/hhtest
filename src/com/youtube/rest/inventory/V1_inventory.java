package com.youtube.rest.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONArray;

import com.youtube.dao.DataSourceSelection;
import com.youtube.util.ToJSON;

@Path("/v1/inventory")
public class V1_inventory {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response returnAllPcParts() throws Exception{
		
		Response rb = null;
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;
		
		try{
			conn = DataSourceSelection.getMySQLDataSource().getConnection();
			query = conn.prepareStatement("select * from computer_part");
			ResultSet rs = query.executeQuery();
			
			ToJSON converter = new ToJSON();
			JSONArray json = new JSONArray();
			
			json = converter.toJSONArray(rs);
			
			returnString = json.toString();
			rb = Response.ok(returnString).build();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(conn != null )
				conn.close();
			query.close();
		}
		return rb;
	}
}
