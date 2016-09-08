package com.marta.yotitest.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marta.yotitest.domainbeans.Point;


public class TestRoomMatrixGraph {
	
	@Test
	public void testAddPatches(){
		
		RoomGraph roomMatrix = RoomMatrixGraph.createinstance(5,5);
		
		roomMatrix.placeHoover(Point.createInstance(1, 2));
		
		roomMatrix.addPatch(Point.createInstance(1, 0));
		roomMatrix.addPatch(Point.createInstance(2, 2));
		roomMatrix.addPatch(Point.createInstance(2, 3));
		
		// all patches in right place
		assertTrue(roomMatrix.isPatch(Point.createInstance(1, 0)));
		assertTrue(roomMatrix.isPatch(Point.createInstance(2, 2)));
		assertTrue(roomMatrix.isPatch(Point.createInstance(2, 3)));
	}
	
	@Test
	public void testMove(){
		RoomGraph roomMatrix = RoomMatrixGraph.createinstance(5,5);
		roomMatrix.placeHoover(Point.createInstance(1, 2));
		roomMatrix.addPatch(Point.createInstance(1, 0));
		roomMatrix.addPatch(Point.createInstance(2, 2));
		roomMatrix.addPatch(Point.createInstance(2, 3));
		
		((HooverControllerReceiver)roomMatrix).moveHooverEast();
		assertEquals(Point.createInstance(2, 2),roomMatrix.getHooverPosition());
		assertEquals(1,roomMatrix.getCleanedPatches());
		
		((HooverControllerReceiver)roomMatrix).moveHooverNorth();
		assertEquals(Point.createInstance(2, 3),roomMatrix.getHooverPosition());
		assertEquals(2,roomMatrix.getCleanedPatches());
		
		((HooverControllerReceiver)roomMatrix).moveHooverNorth();
		assertEquals(Point.createInstance(2, 4),roomMatrix.getHooverPosition());
		((HooverControllerReceiver)roomMatrix).moveHooverNorth();
		assertEquals(Point.createInstance(2, 4),roomMatrix.getHooverPosition());
		
		((HooverControllerReceiver)roomMatrix).moveHooverWest();
		assertEquals(Point.createInstance(1, 4),roomMatrix.getHooverPosition());
		
		((HooverControllerReceiver)roomMatrix).moveHooverWest();
		assertEquals(Point.createInstance(0, 4),roomMatrix.getHooverPosition());
		
		((HooverControllerReceiver)roomMatrix).moveHooverWest();
		assertEquals(Point.createInstance(0, 4),roomMatrix.getHooverPosition());
		
		((HooverControllerReceiver)roomMatrix).moveHooverSouth();
		assertEquals(Point.createInstance(0, 3),roomMatrix.getHooverPosition());
		
		((HooverControllerReceiver)roomMatrix).moveHooverSouth();
		((HooverControllerReceiver)roomMatrix).moveHooverSouth();
		((HooverControllerReceiver)roomMatrix).moveHooverSouth();
		((HooverControllerReceiver)roomMatrix).moveHooverSouth();
		assertEquals(Point.createInstance(0, 0),roomMatrix.getHooverPosition());
		
		
	}

}
