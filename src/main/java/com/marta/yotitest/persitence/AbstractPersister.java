package com.marta.yotitest.persitence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractPersister<T,K> implements Persister<T,K> {
	private final static String URL = "jdbc:sqlite:./db/yotitest.db";

	protected Connection connect() {
        // SQLite connection string
       
        Connection conn = null;
        try {
        	 Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        return conn;
    }
	
	protected boolean existStore(String storeName){
		 String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='"+storeName+"'";
	        
	        try (Connection conn = this.connect();
	             Statement stmt  = conn.createStatement();
	             ResultSet rs    = stmt.executeQuery(sql)){
	            
	        	return rs.next();
	           
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	}
	

}
