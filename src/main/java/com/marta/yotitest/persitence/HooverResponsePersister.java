package com.marta.yotitest.persitence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.codehaus.jettison.json.JSONException;

import com.marta.yotitest.domainbeans.HooverResponse;

public class HooverResponsePersister extends
		AbstractPersister<HooverResponse, String> {
	private static final String TABLE_NAME = "responses";
	
	public static HooverResponsePersister getInstance(){
		return SingletonHelper.INSTANCE;
	}
	
	private static class SingletonHelper{
		private static HooverResponsePersister INSTANCE = new HooverResponsePersister();
	}
	private HooverResponsePersister(){}

	@Override
	public HooverResponse select(String value) throws SQLException{
		 String sql = "SELECT id, json FROM "+TABLE_NAME+";";
		 HooverResponse result = null;
	        
	        try (Connection conn = connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	            // loop through the result set
	            while (rs.next()) {
	            	result = HooverResponse.fromJson(rs.getString("json"));
	                
	            }
	        } catch (SQLException e) {
	            throw new SQLException("Error while quering "+TABLE_NAME+": "+e.getMessage());
	        } catch (JSONException e) {
	        	 throw new SQLException("Error while converting json: "+e.getMessage());
			}
	        return result;
	}

	@Override
	public HooverResponse update(HooverResponse obj) {
		
		return null;
	}

	@Override
	public HooverResponse create(final HooverResponse obj)  throws SQLException{
		String sql = "INSERT INTO "+TABLE_NAME+"(id,json) VALUES(?,?)";
		if(!existStore(TABLE_NAME)){
			createStore();
		}
		try (Connection conn = connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, makeKey(obj));
			pstmt.setString(2, obj.toJson());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new SQLException("Error while saving response:"+obj.toString()+ "in table" + TABLE_NAME+": "+e.getMessage());
		}catch (JSONException e){
			 throw new SQLException("Error while converting json: "+e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(String value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createStore() {
		String sql = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME +"(\n"
                + "	id integer PRIMARY KEY,\n"
                + "	json text NOT NULL );";
        
        try (Connection conn = connect();
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
        	e.printStackTrace();
        }

	}

	@Override
	public String makeKey(HooverResponse obj) {
		return String.valueOf(obj.getCoords()[0])+obj.getCoords()[1]+obj.getPatches();
	}

}
