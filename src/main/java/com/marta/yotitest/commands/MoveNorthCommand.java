package com.marta.yotitest.commands;

import com.marta.yotitest.datastructure.HooverControllerReceiver;
import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.domainbeans.HooverResponse;

public class MoveNorthCommand implements MoveCommand{

public HooverControllerReceiver roomInformation;
	
	
	@Override
	public HooverResponse execute(HooverControllerReceiver roomInformation) {
		roomInformation.moveHooverNorth();
		RoomGraph room = (RoomGraph)roomInformation;
		return HooverResponse.createInstance(room.getHooverPosition().toArray(), room.getCleanedPatches());
	}

}
