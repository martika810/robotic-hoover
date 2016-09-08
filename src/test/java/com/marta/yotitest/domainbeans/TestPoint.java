package com.marta.yotitest.domainbeans;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPoint {
	
	@Test
	public void testEquals(){
		Point point1 = Point.createInstance(1, 2);
		Point point2 = Point.createInstance(1, 2);
		
		//reflesive
		assertTrue(point1.equals(point1));
		
		//symmetric
		assertEquals(point1.equals(point2),point2.equals(point1));
		
		//transitive
		
		assertFalse(point1.equals(null));
		
	}
	
	@Test
	public void testHash(){
		Point point1 = Point.createInstance(1, 2);
		Point point2 = Point.createInstance(1, 2);
		assertEquals(point1.hashCode(),point2.hashCode());
	}

}
