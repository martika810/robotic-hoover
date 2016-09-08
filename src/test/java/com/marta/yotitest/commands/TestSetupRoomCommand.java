package com.marta.yotitest.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.domainbeans.HooverRequest;
import com.marta.yotitest.domainbeans.Point;

public class TestSetupRoomCommand {
	
	@Test
	public void testExecuteCommand(){
		HooverRequest request = new HooverRequest();
		request.setRoomSize(new int[]{5, 5});
		request.setCoords(new int[]{1, 2});
		request.setPatches(new int[][]{{1,0},{2,2},{2,3}});
		Command<HooverRequest,RoomGraph> setupCommand = new SetupRoomCommand();
		RoomGraph room = setupCommand.execute(request);
		
		assertTrue(room.isPatch(Point.valueOf(new int[]{1, 0})));
		assertTrue(room.isPatch(Point.valueOf(new int[]{2, 2})));
		assertTrue(room.isPatch(Point.valueOf(new int[]{2, 3})));
		
		assertFalse(room.isPatch(Point.valueOf(new int[]{0, 0})));
		
	}
	
	
	@Test
	public void testExecuteCommandNoPatches(){
		HooverRequest request = new HooverRequest();
		request.setRoomSize(new int[]{5, 5});
		request.setCoords(new int[]{1, 2});
		//request.setPatches(new int[][]{});
		Command<HooverRequest,RoomGraph> setupCommand = new SetupRoomCommand();
		RoomGraph room = setupCommand.execute(request);
		
		assertFalse(room.isPatch(Point.valueOf(new int[]{1, 0})));
		assertFalse(room.isPatch(Point.valueOf(new int[]{2, 2})));
		assertFalse(room.isPatch(Point.valueOf(new int[]{2, 3})));
		
		
	}

}
