package com.marta.yotitest.commands;

import com.marta.yotitest.datastructure.RoomGraph;
import com.marta.yotitest.datastructure.RoomMatrixGraph;
import com.marta.yotitest.domainbeans.HooverRequest;
import com.marta.yotitest.domainbeans.Point;

public class SetupRoomCommand implements Command<HooverRequest, RoomGraph> {

	@Override
	public RoomGraph execute(HooverRequest request) {
		
		int rows = request.getRoomSize()[0];
		int columns = request.getRoomSize()[1];
		
		RoomGraph roomMatrix = RoomMatrixGraph.createinstance(rows, columns);
		//p
		roomMatrix.placeHoover(Point.valueOf(request.getCoords()));
		
		if (request.getPatches() != null) {
			for (int i = 0; i < request.getPatches().length; i++) {
				Point patch = Point.valueOf(request.getPatches()[i]);
				roomMatrix.addPatch(patch);
			}
		}
		
		return roomMatrix;
	}

}
