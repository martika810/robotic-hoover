package com.marta.yotitest.commands;

import com.marta.yotitest.datastructure.HooverControllerReceiver;
import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.domainbeans.HooverResponse;

public class MoveEastCommand implements MoveCommand {

	@Override
	public HooverResponse execute(HooverControllerReceiver roomInformation) {
		roomInformation.moveHooverEast();
		RoomGraph room = (RoomGraph)roomInformation;
		return HooverResponse.createInstance(room.getHooverPosition().toArray(), room.getCleanedPatches());
	}
	
	

}
