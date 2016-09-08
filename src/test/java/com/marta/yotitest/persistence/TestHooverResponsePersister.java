package com.marta.yotitest.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import com.marta.yotitest.domainbeans.HooverResponse;
import com.marta.yotitest.persitence.HooverResponsePersister;

public class TestHooverResponsePersister {
	
	@Test
	public void testCreate() throws SQLException{
		
		HooverResponse hooverResponse = new HooverResponse();
		hooverResponse.setPatches(3);
		hooverResponse.setCoords(new int[]{1,1});
		
		HooverResponsePersister persister = HooverResponsePersister.getInstance();
		HooverResponse existinghooverResponse = persister.select("113");
		
		if(existinghooverResponse==null){
			assertNotNull(persister.create(hooverResponse));
		}
		
		HooverResponse savedHooverResponse = persister.select("113");
		assertEquals(hooverResponse,savedHooverResponse);
		
	}
	
	

}
