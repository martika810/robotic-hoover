package com.marta.yotitest.commands;

import com.marta.yotitest.datastructure.HooverControllerReceiver;
import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.domainbeans.HooverResponse;

public class MoveWestCommand  implements MoveCommand{
	@Override
	public HooverResponse execute(HooverControllerReceiver roomInformation) {
		roomInformation.moveHooverWest();
		RoomGraph room = (RoomGraph)roomInformation;
		return HooverResponse.createInstance(room.getHooverPosition().toArray(), room.getCleanedPatches());
	}
}
